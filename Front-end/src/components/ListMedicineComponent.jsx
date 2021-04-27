/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import MedicineService from '../services/MedicineService'

class ListMedicineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            medicines: []
        }
        this.addMedicines = this.addMedicines.bind(this);
        this.editMedicine = this.editMedicine.bind(this);
        this.deleteMedicine = this.deleteMedicine.bind(this);
    }
    deleteMedicine(id) {
        MedicineService.deletemedicine(id).then(res => {
            this.setState({ medicines: this.state.medicines.filter(medicine => medicine.medicineId !== id) });
        });
    }
    viewMedicine(id) {
        this.props.history.push(`/view-medicine/${id}`);
    }
    componentDidMount() {
        MedicineService.getMedicines().then((res) => {
            this.setState({ medicines: res.data });
            console.log(this.state.medicines)
        });
    }
    addMedicines() {
        this.props.history.push('/add-medicines/_add');
    }
    editMedicine(id) {
        this.props.history.push(`/update-medicine/${id}`);
    }

    render() {
        return (
            <div>
                <br></br>
                <h2 className="text-center" >Medicines List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addMedicines}><i class="fa fa-plus" aria-hidden="true"></i></button>
                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> Medicine Name</th>
                                <th> Medicine Brand</th>
                                <th> Medicine Price</th>
                                <th> Medicine Category</th>
                                <th> Expiry Date</th>
                                <th> Medicine Description</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.medicines.map(
                                    medicine =>
                                        <tr key={medicine.medicineId}>
                                            <td> {medicine.medicineName} </td>
                                            <td> {medicine.medicineBrand}</td>
                                            <td> {medicine.medicineprice}</td>
                                            <td> {medicine.medicineCategory}</td>
                                            <td> {medicine.expiryDate}</td>
                                            <td> {medicine.medicineDescription}</td>
                                            <td>
                                                <button onClick={() => this.editMedicine(medicine.medicineId)} className="btn btn-info"><i class="fa fa-wrench" aria-hidden="true"></i></button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.deleteMedicine(medicine.medicineId)} className="btn btn-danger"><i class="fa fa-eraser" aria-hidden="true"></i></button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.viewMedicine(medicine.medicineId)} className="btn btn-info"><i class="fa fa-eye-slash" aria-hidden="true"></i></button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>

                </div>

            </div>
        )
    }
}

export default ListMedicineComponent;