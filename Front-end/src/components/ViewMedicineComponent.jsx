/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import MedicineService from '../services/MedicineService';

class ViewMedicineComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            medicine: {}
        }
    }
    componentDidMount() {
        MedicineService.getMedicineById(this.state.id).then(res => {
            this.setState({ medicine: res.data });
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> View Medicine Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label> <strong>Medicine Name :- </strong></label>
                            <div> {this.state.medicine.medicineName}</div>
                        </div>
                        <div className="row">
                            <label> <strong>Medicine Brand :- </strong></label>
                            <div> {this.state.medicine.medicineBrand}</div>
                        </div>
                        <div className="row">
                            <label> <strong>Medicine Price :- </strong></label>
                            <div> {this.state.medicine.medicineprice}</div>
                        </div>
                        <div className="row">
                            <label> <strong>Medicine Category :- </strong></label>
                            <div> {this.state.medicine.medicineCategory}</div>
                        </div>
                        <div className="row">
                            <label> <strong>Medicine ExpiryDate :- </strong></label>
                            <div> {this.state.medicine.expiryDate}</div>
                        </div>
                        <div className="row">
                            <label> <strong>Medicine Description :- </strong></label>
                            <div> {this.state.medicine.medicineDescription}</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default ViewMedicineComponent;
