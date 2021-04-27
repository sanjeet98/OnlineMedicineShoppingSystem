/**
* @author [Sanjeet Kaul]
* @email [kaulsanjeet2gmail.com]
* @create date 2021-04-27 18:40:03
* @modify date 2021-04-27 18:40:03
* @desc [Group Project of Online Medicine Shopping System]
*/
import React, { Component } from 'react';
import PaymentService from '../services/PaymentService'

class ListPaymentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            payments: []
        }
        this.addPayment = this.addPayment.bind(this);
        this.editPayment = this.editPayment.bind(this);
        this.deletePayment = this.deletePayment.bind(this);
    }

    deletePayment(paymentId) {
        PaymentService.deletePayment(paymentId).then(res => {
            this.setState({ payments: this.state.payments.filter(payment => payment.paymentId !== paymentId) });
        });
    }
    viewPayment(paymentId) {
        this.props.history.push(`/view-payment/${paymentId}`);
    }
    editPayment(paymentId) {
        this.props.history.push(`/add-payment/${paymentId}`);
    }


    componentDidMount() {
        PaymentService.getPayments().then((res) => {
            this.setState({ payments: res.data });
            console.log(this.state.payments)
        });

    }

    addPayment() {
        this.props.history.push('/add-payment/_add');
    }

    render() {
        return (
            <div>
                <h2 className="text-center"> Payment Details</h2>
                <div className="row"></div>
                <button className="btn btn-primary" onClick={this.addPayment}> <i class="fa fa-plus" aria-hidden="true"></i> </button>
                <br></br><br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                {/*<th> ID</th>*/}
                                <th> Card Type</th>
                                <th> Card Number</th>
                                <th> Amount</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.payments.map(
                                    payment =>
                                        <tr key={payment.paymentId}>
                                            <td>{payment.cardType}</td>
                                            <td>{payment.cardNo}</td>
                                            <td>{payment.paymentamount}</td>
                                            <td>
                                                <button onClick={() => this.editPayment(payment.paymentId)} className="btn btn-info"> <i class="fa fa-wrench" aria-hidden="true"></i> </button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.deletePayment(payment.paymentId)} className="btn btn-danger"> <i class="fa fa-eraser" aria-hidden="true"></i> </button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.viewPayment(payment.paymentId)} className="btn btn-info"><i class="fa fa-eye-slash" aria-hidden="true"></i> </button>
                                            </td>
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

export default ListPaymentComponent;