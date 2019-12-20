import React, { Component } from 'react';
import Axios from 'axios';
import { APIUrl } from '../../../context/AuthContext';
import { MDBTableHead, MDBTableBody, MDBTable } from 'mdbreact';

class UserManger extends Component {
    state = {
        users: []
    }
    componentDidMount() {
        Axios.get(APIUrl + '/User', { 'headers': { 'Authorization': 'bearer ' + localStorage.getItem("token") } })
            .then((response) => {
                this.setState({
                    users: response.data
                })
            })
            .catch((error) => {
            });
    }
    render() {
        return (
            <MDBTable>
                <MDBTableHead>
                    <tr>
                        <th>UserName</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Address</th>
                    </tr>
                </MDBTableHead>
                <MDBTableBody>
                    {this.state.users.map((user) => {
                        return <tr key={user.userId}>
                            <td>{user.userName}</td>
                            <td>{user.fullName}</td>
                            <td>{user.email}</td>
                            <td>{user.phoneNumber}</td>
                            <td>{user.address}</td>
                        </tr>
                    })}
                </MDBTableBody>
            </MDBTable>
        );
    }
}

export default UserManger;