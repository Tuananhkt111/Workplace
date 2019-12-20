import React, { Component } from 'react';
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCardBody, MDBCard, MDBAlert } from 'mdbreact';
import { APIUrl } from '../../context/AuthContext';
import axios from 'axios';
class Login extends Component {
    state = {

    }
    constructor(props) {
        super(props);
        this.state = {
            user: { username: "", password: "" },
            status: "",
            error: { username: "", password: "" },
            isValidate: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleValidate() {
        var isValidate = true
        var error = this.state.error
        var user = this.state.user
        if (!user.username.match(/^[a-zA-Z0-9]{3,15}$/)) {
            error.username = "User name only contain alphabet and number, length 6-15"
            isValidate = false
        } else {
            error.username = ""
        }
        if (!user.password.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{7,}$/)) {
            error.password = "Password need contain at least one uppercase letter, one lowercase letter, one number and one special character, min length is 7"
            isValidate = false
        } else {
            error.password = ""
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
            user: t,
            ...this.state
        });
    }

    handleSubmit(event) {
        this.handleValidate()
        if (this.state.isValidate === true) {
            axios.post(APIUrl + '/Auth/login', {
                Username: this.state.user.username,
                Password: this.state.user.password
            })
                .then((response) => {
                    if (response.status === 200) {
                        localStorage.setItem("token", response.data.token);
                        this.setState({
                            status: "success"
                        })
                        window.location.replace("/");
                    }
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
            <MDBRow center className="mt-5">
                <MDBCol md="5">
                    <MDBCard>
                        <MDBCardBody>
                            <form onSubmit={this.handleSubmit}>
                                <p className="h2 text-center py-4">Login</p>
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
                                </div>
                                {this.state.status === "fail" ?
                                    <MDBAlert color="danger">
                                        Your user or password is incorrect
                                    </MDBAlert>
                                    : <div></div>
                                }
                                {this.state.status === "success" ?
                                    <MDBAlert color="success">
                                        Login succeed
                                    </MDBAlert>
                                    : <div></div>
                                }
                                <div className="text-center py-4 mt-3">
                                    <MDBBtn color="cyan" type="submit">
                                        Login
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

export default Login;