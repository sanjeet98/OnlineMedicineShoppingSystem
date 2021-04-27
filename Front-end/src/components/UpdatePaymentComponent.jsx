/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react'
import PaymentService from '../services/PaymentService';

class UpdatePaymentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            paymentId: this.props.match.params.paymentId,
            cardType: '',
            cardNo: '',
            paymentamount: ''
        }
        this.changeCardTypeHandler = this.changeCardTypeHandler.bind(this)
        this.changeCardNoHandler = this.changeCardNoHandler.bind(this)
        this.changepaymentamountHandler = this.changepaymentamountHandler.bind(this)
        this.updatePayment = this.updatePayment.bind(this);
    }

    componentDidMount() {
        PaymentService.getPaymentById(this.state.id).then((res) => {
            let payment = res.data;
            this.setState({
                cardType: payment.cardType,
                cardNo: payment.cardNo,
                paymentamount: payment.paymentamount
            });
        });
    }

    updatePayment = (e) => {
        e.preventDefault();
        let payment = { cardType: this.state.cardType, cardNo: this.state.cardNo, paymentamount: this.state.paymentamount };
        console.log('payment => ' + JSON.stringify(payment));
        console.log('id => ' + JSON.stringify(this.state.id));
        PaymentService.updatePayment(payment, this.state.id).then(res => {
            this.props.history.push('/payments');
        });
    }

    changecardTypeHandler = (event) => {
        this.setState({ cardType: event.target.value });
    }

    changecardNoHandler = (event) => {
        this.setState({ cardNo: event.target.value });
    }

    changePaymentAmountHandler = (event) => {
        this.setState({ paymentamount: event.target.value });
    }

    cancel() {
        this.props.history.push('/payments');
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Update Payment</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> First Name: </label>
                                        <input placeholder="First Name" name="cardType" className="form-control"
                                            value={this.state.cardType} onChange={this.changecardTypeHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Last Name: </label>
                                        <input placeholder="Last Name" name="cardNo" className="form-control"
                                            value={this.state.cardNo} onChange={this.changecardNoHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> PaymentAmount Id: </label>
                                        <input placeholder="PaymentAmount" name="paymentamount" className="form-control"
                                            value={this.state.paymentamount} onChange={this.changePaymentAmountHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.updatePayment}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default UpdatePaymentComponent