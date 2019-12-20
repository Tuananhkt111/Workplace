import React, { Component } from 'react';
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCardBody, MDBCard, MDBAlert } from 'mdbreact';
import { APIUrl } from '../../context/AuthContext';
import Axios from 'axios';
class Register extends Component {
    state = {}
    constructor(props) {
        super(props);
        this.state = {
            user: {
                username: "",
                password: "",
                fullname: "",
                email: "",
                phone: "",
                address: "",
                confirm: ""
            },
            status: "",
            error: {
                username: "",
                password: "",
                fullname: "",
                email: "",
                phone: "",
                address: "",
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
        if (!user.fullname.match(/^[a-zA-Z ]+$/)) {
            error.fullname = "Full name only contain alphabet"
            isValidate = false
        } else {
            error.fullname = ""
        }
        if (!user.username.match(/^[a-zA-Z0-9]{6,15}$/)) {
            error.username = "User name only contain alphabet and number, length 6-15"
            isValidate = false
        } else {
            error.username = ""
        }
        if (!user.phone.match(/^[0-9]{9,12}$/)) {
            error.phone = "Phone number only contain number, length 9-12"
            isValidate = false
        } else {
            error.phone = ""
        }
        if (!user.password.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{7,}$/)) {
            error.password = "Password need contain at least one uppercase letter, one lowercase letter, one number and one special character, min length is 7"
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
            Axios.post(APIUrl + '/Auth/register', {
                Username: this.state.user.username,
                Password: this.state.user.password,
                Email: this.state.user.email,
                PhoneNumber: this.state.user.phone,
                Address: this.state.user.address,
                FullName: this.state.user.fullname
            })
                .then((response) => {
                    this.setState({
                        status: "success"
                    })
                    window.location.replace("/login")
                })
                .catch((error) => {
                    console.log(error)
                    this.setState({
                        status: "fail"
                    })
                });
        }
        event.preventDefault();
    }
    render() {
        return (
            <MDBRow center className="mt-5">
                <MDBCol md="5">
                    <MDBCard>
                        <MDBCardBody>
                            <form onSubmit={this.handleSubmit}>
                                <p className="h2 text-center py-4">Register</p>
                                <div className="grey-text">
                                    <MDBInput
                                        value={this.state.user.username}
                                        onChange={this.handleChange}
                                        name="username"
                                        label="Username"
                                        icon="user-tag"
                                        group
                                        type="text"
                                        required
                                    />
                                    {this.state.error.username !== "" ? <div className="text-danger text-right">{this.state.error.username}</div> : <div></div>}
                                    <MDBInput
                                        value={this.state.user.fullname}
                                        onChange={this.handleChange}
                                        name="fullname"
                                        label="Your full name"
                                        icon="user"
                                        group
                                        type="text"
                                        required
                                    />
                                    {this.state.error.fullname !== "" ? <div className="text-danger text-right">{this.state.error.fullname}</div> : <div></div>}
                                    <MDBInput
                                        value={this.state.user.email}
                                        onChange={this.handleChange}
                                        name="email"
                                        label="Email"
                                        icon="envelope"
                                        group
                                        type="email"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.user.phone}
                                        onChange={this.handleChange}
                                        name="phone"
                                        label="Phone number"
                                        icon="phone"
                                        group
                                        type="tel"
                                        required
                                    />
                                    {this.state.error.phone !== "" ? <div className="text-danger text-right">{this.state.error.phone}</div> : <div></div>}
                                    <MDBInput
                                        value={this.state.user.address}
                                        onChange={this.handleChange}
                                        name="address"
                                        label="Address"
                                        icon="home"
                                        group
                                        type="text"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.user.password}
                                        onChange={this.handleChange}
                                        name="password"
                                        label="Password"
                                        icon="lock"
                                        group
                                        type="password"
                                        required
                                    />
                                    {this.state.error.password !== "" ? <div className="text-danger text-right">{this.state.error.password}</div> : <div></div>}
                                    <MDBInput
                                        value={this.state.user.confirm}
                                        onChange={this.handleChange}
                                        name="confirm"
                                        label="Confirm password"
                                        icon="lock"
                                        group
                                        type="password"
                                        required
                                    />
                                    {this.state.error.confirm !== "" ? <div className="text-danger text-right">{this.state.error.confirm}</div> : <div></div>}
                                </div>
                                {this.state.status === "fail" ?
                                    <MDBAlert color="danger">
                                        Regist failed, username has existed
                                    </MDBAlert>
                                    : <div></div>
                                }
                                {this.state.status === "success" ?
                                    <MDBAlert color="success">
                                        Regist succeed
                                    </MDBAlert>
                                    : <div></div>
                                }
                                <div className="text-center py-4 mt-3">
                                    <MDBBtn color="cyan" type="submit">
                                        Register
                  </MDBBtn>
                                </div>
                            </form>

                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
        );
    }
}

export default Register;