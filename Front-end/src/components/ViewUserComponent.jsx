/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import UserService from '../services/UserService';

class ViewUserComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            user: {}
        }
    }
    componentDidMount() {
        UserService.getUserById(this.state.id).then(res => {
            this.setState({ user: res.data });
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> View User Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label> <strong>User Name :- </strong></label>
                            <div> {this.state.user.userName}</div>
                        </div>
                        <div className="row">
                            <label> <strong>User Address :- </strong></label>
                            <div> {this.state.user.userAddress}</div>
                        </div>
                        <div className="row">
                            <label> <strong>User PhoneNumber :- </strong></label>
                            <div> {this.state.user.userPhno}</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default ViewUserComponent;