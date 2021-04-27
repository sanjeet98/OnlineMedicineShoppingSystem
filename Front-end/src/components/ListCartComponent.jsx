/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import CartService from '../services/CartService'

class ListCartComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            confirmcart: []
        }
    }



    componentDidMount() {
        CartService.getCart().then((res) => {
            this.setState({ confirmcart: res.data });
            console.log(this.state.confirmcart)
        });

    }



    render() {
        return (
            <div>
                <h2 className="text-center"> Cart Details</h2>
                <br></br>
                <div className="row"></div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> User Name</th>
                                <th> Cart Status</th>
                                <th> Date of Order</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.confirmcart.map(
                                    cart =>
                                        <tr key={cart.cartId}>
                                            <td>{cart.user.userName}</td>
                                            <td>{cart.cartStatus}</td>
                                            <td>{cart.dateOfOrder}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListCartComponent;