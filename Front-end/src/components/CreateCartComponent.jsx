/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import CartService from '../services/CartService';


class CreateCartComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            cartId: this.props.match.params.cartId,
            user: '',
            cartStatus: '',
            dateOfOrder: ''
        }

        this.changeUserHandler = this.changeUserHandler.bind(this)
        this.changeCartStatusHandler = this.changeCartStatusHandler.bind(this)
        this.changeDateOfOrderHandler = this.changeDateOfOrderHandler.bind(this)
        this.saveorUpdateCart = this.saveorUpdateCart.bind(this);
    }

    componentDidMount() {

        if (this.state.cartId === '_add') {
            return
        } else {
            CartService.getCartById(this.state.cartId).then((res) => {
                let cart = res.data;
                this.setState({
                    user: cart.user,
                    cartStatus: cart.cartStatus,
                    dateOfOrder: cart.dateOfOrder
                });
            });
        }
    }

    saveorUpdateCart = (e) => {
        e.preventDefault();
        let cart = { user: this.state.user, cartStatus: this.state.cartStatus, dateOfOrder: this.state.dateOfOrder };
        console.log('cart => ' + JSON.stringify(cart));

        if (this.state.cartId === '_add') {
            CartService.createCart(cart).then(res => {
                this.props.history.push('/confirmcart');
            });
        } else {
            CartService.updateCart(cart, this.state.cartId).then(res => {
                this.props.history.push('/confirmcart');
            });
        }
    }

    changeUserHandler = (event) => {
        this.setState({ user: event.target.value });
    }
    changeCartStatusHandler = (event) => {
        this.setState({ cartStatus: event.target.value });
    }
    changeDateOfOrderHandler = (event) => {
        this.setState({ dateOfOrder: event.target.value });
    }

    cancel() {
        this.props.history.push('/confirmcart');
    }


    getTitle() {
        if (this.state.cartId === '_add') {
            return <h3 className="text-center">Add Cart</h3>
        } else {
            return <h3 className="text-center">Update Cart</h3>
        }
    }


    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> User: </label>
                                        <input placeholder="User" name="user" className="form-control"
                                            value={this.state.user} onChange={this.changeUserHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Cart Status: </label>
                                        <input placeholder="Cart Status" name="cartStatus" className="form-control"
                                            value={this.state.cartStatus} onChange={this.changeCartStatusHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Date of Order: </label>
                                        <input placeholder="Date of Order" name="dateOfOrder" className="form-control"
                                            value={this.state.dateOfOrder} onChange={this.changeDateOfOrderHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveorUpdateCart}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}


export default CreateCartComponent;