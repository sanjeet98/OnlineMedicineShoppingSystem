/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import PaymentService from '../services/PaymentService';

const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-9]+$/);

const formValid = ({ isError, ...rest }) => {
    let valid = true;

    Object.values(isError).forEach((val) => {
        val.length > 0 && (valid = false);
    });

    Object.values(rest).forEach((val) => {
        val == null && (valid = false);
    });

    return valid;
};

class CreatePaymentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            paymentId: this.props.match.params.paymentId,
            cardType: '',
            cardNo: '',
            paymentamount: '',
            isError: {
                cardType: '',
                cardNo: '',
                paymentamount: ''
            }
        }

        this.changeCardTypeHandler = this.changeCardTypeHandler.bind(this)
        this.changeCardNoHandler = this.changeCardNoHandler.bind(this)
        this.changePaymentAmountHandler = this.changePaymentAmountHandler.bind(this)
        this.saveorUpdatePayment = this.saveorUpdatePayment.bind(this);
    }

    componentDidMount() {

        if (this.state.paymentId === '_add') {
            return
        } else {
            PaymentService.getPaymentById(this.state.paymentId).then((res) => {
                let payment = res.data;
                this.setState({
                    cardType: payment.cardType,
                    cardNo: payment.cardNo,
                    paymentamount: payment.paymentamount
                });
            });
        }
    }

    saveorUpdatePayment = (e) => {
        e.preventDefault();

        if (formValid(this.state)) {

            let payment = { cardType: this.state.cardType, cardNo: this.state.cardNo, paymentamount: this.state.paymentamount };
            console.log('payment => ' + JSON.stringify(payment));

            if (this.state.paymentId === '_add') {
                PaymentService.createPayment(payment).then(res => {
                    this.props.history.push('/payments');
                });
            } else {
                PaymentService.updatePayment(payment, this.state.paymentId).then(res => {
                    this.props.history.push('/payments');
                });
            }
            alert("Form is Valid");
        }
        else {
            alert("Form is Invalid");
        }
    }

    changeCardTypeHandler = (event) => {
        this.setState({ cardType: event.target.value });
    }
    changeCardNoHandler = (event) => {
        this.setState({ cardNo: event.target.value });
    }
    changePaymentAmountHandler = (event) => {
        this.setState({ paymentamount: event.target.value });
    }

    formValChange = (e) => {
        e.preventDefault();
        const { name, value } = e.target;
        let isError = { ...this.state.isError };
        switch (name) {
            case "cardType":
                isError.cardType =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;
            case "cardNo":
                isError.cardNo =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;

            case "paymentamount":
                isError.paymentamount = regExp2.test(value) ? "" : "Numeric Values Required";
                break;
            default:
                break;
        }
        this.setState(
            {
                isError,
                [name]: value,
                disabled: false,
            },
            () => console.log(this.state)
        );
    };

    cancel() {
        this.props.history.push('/payments');
    }


    getTitle() {
        if (this.state.paymentId === '_add') {
            return <h3 className="text-center">Add Payment</h3>
        } else {
            return <h3 className="text-center">Update Payment</h3>
        }
    }


    render() {
        const { isError } = this.state;
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
                                        <label> Card Type: </label>
                                        <input placeholder="Card Type" name="cardType" className={
                                            isError.cardType.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.cardType} onChange={(this.changeCardTypeHandler, this.formValChange)} />
                                        {isError.cardType.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.cardType}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label> Card Number: </label>
                                        <input placeholder="Card Number" name="cardNo" className={
                                            isError.cardNo.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.cardNo} onChange={(this.changeCardNoHandler, this.formValChange)} />
                                        {isError.cardNo.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.cardNo}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label> Payment Amount: </label>
                                        <input placeholder="Amount" name="paymentamount" className={
                                            isError.paymentamount.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.paymentamount} onChange={(this.changePaymentAmountHandler, this.formValChange)} />
                                        {isError.paymentamount.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.paymentamount}
                                            </span>
                                        )}
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveorUpdatePayment}>Save</button>
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


export default CreatePaymentComponent;