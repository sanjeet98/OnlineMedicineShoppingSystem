/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import UserService from '../services/UserService';



class UpdateUserComponent extends Component {
    constructor(props) {
        super(props)
        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeUserAddressHandler = this.changeUserAddressHandler.bind(this);
        this.changeUserPhoneNumberHandler = this.changeUserPhoneNumberHandler.bind(this);
        this.updateUser = this.updateUser.bind(this);

        this.state = {
            id: this.props.match.params.id,
            userName: '',
            userAddress: '',
            userPhno: ''
        }
    }

    componentDidMount() {

        UserService.getUserById(this.state.id).then((res) => {
            let user = res.data;
            this.setState({
                userName: user.userName,
                userAddress: user.userAddress,
                userPhno: user.userPhno
            });
        });

    }

    updateUser = (m) => {
        m.preventDefault();
        let user = { userId: this.state.id, userName: this.state.userName, userAddress: this.state.userAddress, userPhno: this.state.userPhno };
        console.log('user => ' + JSON.stringify(user));
        console.log('id => ' + JSON.stringify(this.state.id));
        UserService.updateuser(user, this.state.id).then(res => {
            this.props.history.push('/users');
        });

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

    cancel() {
        this.props.history.push('/users');

    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Update User</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>User Name</label>
                                        <input placeholder="User Name" name="userName" className="form-control"
                                            value={this.state.userName} onChange={this.changeUserNameHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>User Address</label>
                                        <input placeholder="User Address" name="userAddress" className="form-control"
                                            value={this.state.userAddress} onChange={this.changeUserAddressHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>User PhoneNumber</label>
                                        <input placeholder="User PhoneNumber" name="userPhno" className="form-control"
                                            value={this.state.userPhno} onChange={this.changeUserPhoneNumberHandler} />
                                    </div>
                                    <button className="btn btn-success" onClick={this.updateUser}>Save</button>
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

export default UpdateUserComponent;