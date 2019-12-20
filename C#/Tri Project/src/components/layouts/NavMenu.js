import React, { Component } from 'react';
import { Navbar } from 'react-bootstrap';
import {Link} from 'react-router-dom';
import UserMenu from './UserMenu';

class NavMenu extends Component {
    state = {}
    render() {
        return (
            <Navbar bg="primary" variant="dark">
                <Navbar.Brand as={Link} to="/">PhoneShop</Navbar.Brand>
                <UserMenu/>
            </Navbar>
        );
    }
}

export default NavMenu;