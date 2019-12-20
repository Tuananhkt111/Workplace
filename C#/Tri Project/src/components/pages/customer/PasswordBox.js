import React, { Component } from 'react';
import { MDBCol, MDBCard, MDBCardBody, MDBInput, MDBBtn, MDBAlert } from 'mdbreact';
import Axios from 'axios';
import { APIUrl } from '../../../context/AuthContext';
import JwtDecode from 'jwt-decode';

class PasswordBox extends Component {
    state = {}
    constructor(props) {
        super(props);
        this.state = {
            user: {
                oldPassword: "",
                newPassword: "",
                confirm: ""
            },
            status: "",
            error: {
                oldPassword: "",
                newPassword: "",
                confirm: ""
            },
            isValidate: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleValidate() {
        var isValidate = true
        var error = this.state.error
        var user = this.state.user
        if (!user.oldPassword.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{7,}$/)) {
            error.oldPassword = "Password need contain at least one uppercase letter, one lowercase letter, one number and one special character, min length is 7"
            isValidate = false
        } else {
            error.oldPassword = ""
        }
        if (!user.newPassword.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{7,}$/)) {
            error.newPassword = "Password need contain at least one uppercase letter, one lowercase letter, one number and one special character, min length is 7"
            isValidate = false
        } else {
            error.password = ""
        }
        if (user.confirm !== user.password) {
            error.confirm = "Confirm need to match with password"
            isValidate = false
        } else {
            error.confirm = ""
        }
        this.setState({
            error: error,
            isValidate: isValidate
        })
    }
    handleChange(event) {
        const target = event.target;
        const name = target.name;
        const t = this.state.user;
        t[name] = target.value;
        this.setState({
            user: t
        });
    }

    handleSubmit(event) {
        this.handleValidate()
        if (this.state.isValidate === true) {
            var decoded = JwtDecode(localStorage.getItem("token"));
            Axios.put(APIUrl + '/User/changePassword/' + decoded.unique_name, {
                UserId: decoded.unique_name,
                Password: this.state.user.oldPassword,
                NewPassword: this.state.user.newPassword
            }, { 'headers': { 'Authorization': 'bearer ' + localStorage.getItem("token") } })
                .then((response) => {
                    this.setState({
                        status: "success"
                    })
                })
                .catch((error) => {
                    this.setState({
                        status: "fail"
                    })
                });
        }
        event.preventDefault();
    }
    render() {
        return (
            <MDBCol>
                <MDBCard>
                    <MDBCardBody>
                        <form onSubmit={this.handleSubmit}>
                            <p className="h2 text-center py-4">Change password</p>
                            <div className="grey-text">
                                <MDBInput
                                    value={this.state.user.oldPassword}
                                    onChange={this.handleChange}
                                    name="oldPassword"
                                    label="Old password"
                                    icon="lock"
                                    group
                                    type="password"
                                    required
                                />
                                {this.state.error.oldPassword !== "" ? <div className="text-danger text-right">{this.state.error.oldPassword}</div> : <div></div>}
                                <MDBInput
                                    value={this.state.user.newPassword}
                                    onChange={this.handleChange}
                                    name="newPassword"
                                    label="New password"
                                    icon="lock"
                                    group
                                    type="password"
                                    required
                                />
                                {this.state.error.newPassword !== "" ? <div className="text-danger text-right">{this.state.error.newPassword}</div> : <div></div>}
                                <MDBInput
                                    value={this.state.user.confirm}
                                    onChange={this.handleChange}
                                    name="confirm"
                                    label="Confirm new password"
                                    icon="lock"
                                    group
                                    type="password"
                                    required
                                />
                                {this.state.error.confirm !== "" ? <div className="text-danger text-right">{this.state.error.confirm}</div> : <div></div>}
                            </div>
                            {this.state.status === "fail" ?
                                <MDBAlert color="danger">
                                    Update failed
                                    </MDBAlert>
                                : <div></div>
                            }
                            {this.state.status === "success" ?
                                <MDBAlert color="success">
                                    Update succeed
                                    </MDBAlert>
                                : <div></div>
                            }
                            <div className="text-center py-4 mt-3">
                                <MDBBtn color="cyan" type="submit">
                                    Change
                  </MDBBtn>
                            </div>
                        </form>
                    </MDBCardBody>
                </MDBCard>
            </MDBCol>
        );
    }
}

export default PasswordBox;