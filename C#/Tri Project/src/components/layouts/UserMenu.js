import React, { Component } from 'react';
import { Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import authContext from '../../context/AuthContext';
var jwtDecode = require('jwt-decode');
class UserMenu extends Component {
    state = { role: ""}
    componentDidMount() {
        var token = authContext.getToken();
        if (token != null) {
            var decoded = jwtDecode(token);
            this.setState({
                role: decoded.role
            })
        } else {
            this.setState({
                role: ""
            })
        }
    }
    render() {
        return (
            <React.Fragment>
                {this.state.role === "" ? this.unauth() : this.auth()}
            </React.Fragment>
        );
    }
    unauth = () => {
        return <Nav className="mr-auto">
            <Nav.Link as={Link} to="/login">Login</Nav.Link>
            <Nav.Link as={Link} to="/register">Register</Nav.Link>
        </Nav>
    }
    auth = () => {
        if (this.state.role === "Admin") {
        return <Nav className="mr-auto">
            <Nav.Link as={Link} to="/profile">Profile</Nav.Link>
            <Nav.Link as={Link} to="/admin">Manager</Nav.Link>
            <Nav.Link onClick={() => {localStorage.clear()}} href="/">Logout</Nav.Link>
        </Nav>
        } else {
            return <Nav className="mr-auto">
            <Nav.Link as={Link} to="/profile">Profile</Nav.Link>
        <Nav.Link as={Link} to="/cart">Cart</Nav.Link>
            <Nav.Link onClick={() => {localStorage.clear()}} href="/">Logout</Nav.Link>
        </Nav>
        }
    }
}

export default UserMenu;