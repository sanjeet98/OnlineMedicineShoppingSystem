/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';
import UserService from '../services/UserService'

class ListUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
        this.addUsers = this.addUsers.bind(this);
        this.editUser = this.editUser.bind(this);
        this.deleteUser = this.deleteUser.bind(this);
    }
    deleteUser(id) {
        UserService.deleteuser(id).then(res => {
            this.setState({ users: this.state.users.filter(user => user.userId !== id) });
        });
    }
    viewUser(id) {
        this.props.history.push(`/view-user/${id}`);
    }
    componentDidMount() {
        UserService.getUsers().then((res) => {
            this.setState({ users: res.data });
            console.log(this.state.users)
        });
    }
    addUsers() {
        this.props.history.push('/add-users/_add');
    }
    editUser(id) {
        this.props.history.push(`/update-user/${id}`);
    }

    render() {
        return (
            <div>
                <br></br>
                <h2 className="text-center">Users List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addUsers}><i class="fa fa-plus" aria-hidden="true"></i></button>
                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> User Name</th>
                                <th> User Address</th>
                                <th> Phone Number</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                        <tr key={user.userId}>
                                            <td> {user.userName} </td>
                                            <td> {user.userAddress}</td>
                                            <td> {user.userPhno}</td>
                                            <td>
                                                <button onClick={() => this.editUser(user.userId)} className="btn btn-info"><i class="fa fa-wrench" aria-hidden="true"></i></button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.deleteUser(user.userId)} className="btn btn-danger"><i class="fa fa-eraser" aria-hidden="true"></i></button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.viewUser(user.userId)} className="btn btn-info"><i class="fa fa-eye-slash" aria-hidden="true"></i></button>
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

export default ListUserComponent;