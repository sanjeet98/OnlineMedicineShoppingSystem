/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react'
import PaymentService from '../services/PaymentService'

class ViewPaymentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            paymentId: this.props.match.params.paymentId,
            payment: {}
        }
    }

    componentDidMount() {
        PaymentService.getPaymentById(this.state.paymentId).then(res => {
            this.setState({ payment: res.data });
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> View Payment Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label> Card Type: </label>
                            <div> {this.state.payment.cardType}</div>
                        </div>
                        <div className="row">
                            <label> Card Number: </label>
                            <div> {this.state.payment.cardNo}</div>
                        </div>
                        <div className="row">
                            <label> Payment Amount: </label>
                            <div> {this.state.payment.paymentamount}</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewPaymentComponent