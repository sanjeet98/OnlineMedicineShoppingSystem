/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import MedicineService from '../services/MedicineService';

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

class CreateMedicineComponent extends Component {
    constructor(props) {
        super(props)
        this.changeMedicineNameHandler = this.changeMedicineNameHandler.bind(this);
        this.changeMedicineBrandHandler = this.changeMedicineBrandHandler.bind(this);
        this.changeMedicinePriceHandler = this.changeMedicinePriceHandler.bind(this);
        this.changeMedicineCategoryHandler = this.changeMedicineCategoryHandler.bind(this);
        this.changeMedicineExpiryDateHandler = this.changeMedicineExpiryDateHandler.bind(this);
        this.changeMedicineDescriptionHandler = this.changeMedicineDescriptionHandler.bind(this);
        this.saveOrUpdateMedicine = this.saveOrUpdateMedicine.bind(this);

        this.state = {
            id: this.props.match.params.id,
            medicineName: '',
            medicineBrand: '',
            medicineprice: '',
            medicineCategory: '',
            expiryDate: '',
            medicineDescription: '',
            isError: {
                medicineName: '',
                medicineBrand: '',
                medicineprice: '',
                medicineCategory: '',
                expiryDate: '',
                medicineDescription: ''
            }
        }
    }

    saveOrUpdateMedicine = (m) => {
        m.preventDefault();


        if (formValid(this.state)) {


            let medicine = {
                medicineName: this.state.medicineName, medicineBrand: this.state.medicineBrand, medicineprice: this.state.medicineprice
                , medicineCategory: this.state.medicineCategory, expiryDate: this.state.expiryDate, medicineDescription: this.state.medicineDescription
            };

            console.log('medicine => ' + JSON.stringify(medicine));

            if (this.state.id === '_add') {
                MedicineService.createMedicine(medicine).then(res => {
                    this.props.history.push('/medicines');
                });
            } else {
                MedicineService.updatemedicine(medicine, this.state.id).then(res => {
                    this.props.history.push('/medicines');
                });
            }
            alert("form is valid");
        }

        else {
            alert("form is invalid");
        }
    }

    componentDidMount() {

        if (this.state.id === '_add') {
            return
        } else {
            MedicineService.getMedicineById(this.state.id).then((res) => {
                let medicine = res.data;
                this.setState({
                    medicineName: medicine.medicineName,
                    medicineBrand: medicine.medicineBrand,
                    medicineprice: medicine.medicineprice,
                    medicineCategory: medicine.medicineCategory,
                    expiryDate: medicine.expiryDate,
                    medicineDescription: medicine.medicineDescription
                });
            });
        }
    }

    changeMedicineNameHandler = (event) => {
        this.setState({ medicineName: event.target.value });
    }

    changeMedicineBrandHandler = (event) => {
        this.setState({ medicineBrand: event.target.value });
    }

    changeMedicinePriceHandler = (event) => {
        this.setState({ medicineprice: event.target.value });
    }

    changeMedicineCategoryHandler = (event) => {
        this.setState({ medicineCategory: event.target.value });
    }

    changeMedicineExpiryDateHandler = (event) => {
        this.setState({ expiryDate: event.target.value });
    }

    changeMedicineDescriptionHandler = (event) => {
        this.setState({ medicineDescription: event.target.value });
    }


    formValChange = (e) => {
        e.preventDefault();
        const { name, value } = e.target;
        let isError = { ...this.state.isError };
        switch (name) {
            case "medicineName":
                isError.medicineName =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;
            case "medicineBrand":
                isError.medicineBrand =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;

            case "medicineprice":
                isError.medicineprice = regExp2.test(value) ? "" : "Numeric Values Required";
                break;
            case "medicineCategory":
                isError.medicineCategory = value.length < 4 ? "Atleast 4 characters required" : "";
                break;

            case "expiryDate":
                isError.expiryDate =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;

            case "medicineDescription":
                isError.medicineDescription =
                    value.length < 5 ? "Atleast 5 characters required" : "";
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
        this.props.history.push('/medicines');
    }

    getTitle() {
        if (this.state.id === '_add') {
            return <h3 className="text-center">Add Medicine</h3>
        } else {
            return <h3 className="text-center">Update Medicine</h3>
        }
    }

    render() {
        const { isError } = this.state;
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form className="needs-validation" noValidate>
                                    <div className="form-group">
                                        <label>Medicine Name</label>
                                        <input placeholder="Medicine Name" name="medicineName" className={
                                            isError.medicineName.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.medicineName} onChange={(this.changeMedicineNameHandler, this.formValChange)} />
                                        {isError.medicineName.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.medicineName}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>Medicine Brand</label>
                                        <input placeholder="Medicine Brand" name="medicineBrand" className={
                                            isError.medicineBrand.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.medicineBrand} onChange={(this.changeMedicineBrandHandler, this.formValChange)} />
                                        {isError.medicineBrand.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.medicineBrand}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>Medicine Price</label>
                                        <input placeholder="Medicine Price" name="medicineprice" className={
                                            isError.medicineprice.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.medicineprice} onChange={(this.changeMedicinePriceHandler, this.formValChange)} />
                                        {isError.medicineprice.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.medicineprice}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>Medicine Category</label>
                                        <input placeholder="Medicine Category" name="medicineCategory" className={
                                            isError.medicineCategory.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.medicineCategory} onChange={(this.changeMedicineCategoryHandler, this.formValChange)} />
                                        {isError.medicineCategory.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.medicineCategory}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>Medicine ExpiryDate</label>
                                        <input placeholder="Medicine ExpiryDate" name="expiryDate" className={
                                            isError.expiryDate.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.expiryDate} onChange={(this.changeMedicineExpiryDateHandler, this.formValChange)} />
                                        {isError.expiryDate.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.expiryDate}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>Medicine Description</label>
                                        <input placeholder="Medicine Description" name="medicineDescription" className={
                                            isError.medicineDescription.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.medicineDescription} onChange={(this.changeMedicineDescriptionHandler, this.formValChange)} />
                                        {isError.medicineDescription.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.medicineDescription}
                                            </span>
                                        )}
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveOrUpdateMedicine}>Save</button>
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

export default CreateMedicineComponent;