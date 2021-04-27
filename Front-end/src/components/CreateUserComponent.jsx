/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import UserService from '../services/UserService';

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


class CreateUserComponent extends Component {
    constructor(props) {
        super(props)
        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeUserAddressHandler = this.changeUserAddressHandler.bind(this);
        this.changeUserPhoneNumberHandler = this.changeUserPhoneNumberHandler.bind(this);
        this.saveOrUpdateUser = this.saveOrUpdateUser.bind(this);

        this.state = {
            id: this.props.match.params.id,
            userName: '',
            userAddress: '',
            userPhno: '',
            isError: {
                userName: '',
                userAddress: '',
                userPhno: ''
            }
        }
    }

    saveOrUpdateUser = (m) => {
        m.preventDefault();

        if (formValid(this.state)) {



            let user = { userName: this.state.userName, userAddress: this.state.userAddress, userPhno: this.state.userPhno };

            console.log('user => ' + JSON.stringify(user));

            if (this.state.id === '_add') {
                UserService.createUser(user).then(res => {
                    this.props.history.push('/users');
                });
            } else {
                UserService.updateuser(user, this.state.id).then(res => {
                    this.props.history.push('/users');
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
            UserService.getUserById(this.state.id).then((res) => {
                let user = res.data;
                this.setState({
                    userName: user.userName,
                    userAddress: user.userAddress,
                    userPhno: user.userPhno,
                });
            });
        }
    }

    changeUserNameHandler = (event) => {
        this.setState({ userName: event.target.value });
    }

    changeUserAddressHandler = (event) => {
        this.setState({ userAddress: event.target.value });
    }

    changeUserPhoneNumberHandler = (event) => {
        this.setState({ userPhno: event.target.value });
    }

    formValChange = (e) => {
        e.preventDefault();
        const { name, value } = e.target;
        let isError = { ...this.state.isError };
        switch (name) {
            case "userName":
                isError.userName =
                    value.length < 3 ? "Atleast 3 characters required" : "";
                break;
            case "userAddress":
                isError.userAddress =
                    value.length < 5 ? "Atleast 5 characters required" : "";
                break;

            case "userPhno":
                isError.userPhno = regExp2.test(value) ? "" : "Numeric Values Required";
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
        this.props.history.push('/users');
    }

    getTitle() {
        if (this.state.id === '_add') {
            return <h3 className="text-center">Add User</h3>
        } else {
            return <h3 className="text-center">Update user</h3>
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
                                <form>
                                    <div className="form-group">
                                        <label>User Name</label>
                                        <input placeholder="User Name" name="userName" className={
                                            isError.userName.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.userName} onChange={(this.changeUserNameHandler, this.formValChange)} />
                                        {isError.userName.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.userName}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>User Address</label>
                                        <input placeholder="User Address" name="userAddress" className={
                                            isError.userAddress.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.userAddress} onChange={(this.changeUserAddressHandler, this.formValChange)} />
                                        {isError.userAddress.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.userAddress}
                                            </span>
                                        )}
                                    </div>
                                    <div className="form-group">
                                        <label>User PhoneNumber</label>
                                        <input placeholder="User PhoneNumber" name="userPhno" className={
                                            isError.userPhno.length > 0
                                                ? "is-invalid form-control"
                                                : "form-control"
                                        }
                                            value={this.state.userPhno} onChange={(this.changeUserPhoneNumberHandler, this.formValChange)} />
                                        {isError.userPhno.length > 0 && (
                                            <span className="invalid-feedback">
                                                {isError.userPhno}
                                            </span>
                                        )}
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveOrUpdateUser}>Save</button>
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

export default CreateUserComponent;