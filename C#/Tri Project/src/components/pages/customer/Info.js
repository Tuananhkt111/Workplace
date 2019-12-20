import React, { Component } from 'react';
import { MDBCol, MDBCard, MDBCardBody, MDBInput, MDBBtn, MDBAlert } from 'mdbreact';
import Axios from 'axios';
import { APIUrl } from '../../../context/AuthContext';
import JwtDecode from 'jwt-decode';

class Info extends Component {
    state = {}
    constructor(props) {
        super(props);
        this.state = {
            user: {
                fullname: "",
                email: "",
                phone: "",
                address: ""
            },
            status: "",
            error: {
                fullname: "",
                email: "",
                phone: "",
                address: ""
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
        if (!user.phone.match(/^[0-9]{9,12}$/)) {
            error.phone = "Phone number only contain number, length 9-12"
            isValidate = false
        } else {
            error.phone = ""
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
            Axios.put(APIUrl + '/User/update/' + decoded.unique_name, {
                UserId: decoded.unique_name,
                Email: this.state.user.email,
                PhoneNumber: this.state.user.phone,
                Address: this.state.user.address,
                FullName: this.state.user.fullname
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
    componentDidMount() {
        var decoded = JwtDecode(localStorage.getItem("token"));
        Axios.get(APIUrl + '/User/' + decoded.unique_name,
            { 'headers': { 'Authorization': 'bearer ' + localStorage.getItem("token") } })
            .then((res) => {
                this.setState({
                    user: {
                        fullname: res.data.fullName,
                        email: res.data.email,
                        phone: res.data.phoneNumber,
                        address: res.data.address
                    }
                })
            }).catch((err) => {
                window.location.replace("/error");
            });
    }
    render() {
        return (
            <MDBCol>
                <MDBCard>
                    <MDBCardBody>
                        <form onSubmit={this.handleSubmit}>
                            <p className="h2 text-center py-4">Info</p>
                            <div className="grey-text">
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
                                    Update
                  </MDBBtn>
                            </div>
                        </form>
                    </MDBCardBody>
                </MDBCard>
            </MDBCol>
        );
    }
}

export default Info;