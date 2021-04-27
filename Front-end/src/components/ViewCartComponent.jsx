/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react'
import CartService from '../services/CartService'

class ViewCartComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            cartId: this.props.match.params.cartId,
            cart: {}
        }
    }

    componentDidMount() {
        CartService.getCartById(this.state.cartId).then(res => {
            this.setState({ cart: res.data });
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> View Cart Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <div className="row">
                                <label> User: </label>
                                <div> {this.state.cart.user}</div>
                            </div>
                            <label> Cart Status: </label>
                            <div> {this.state.cart.cartStatus}</div>
                        </div>
                        <div className="row">
                            <label> Date of Order: </label>
                            <div> {this.state.cart.dateOfOrder}</div>
                        </div>

                    </div>

                </div>
            </div>
        )
    }
}

export default ViewCartComponent