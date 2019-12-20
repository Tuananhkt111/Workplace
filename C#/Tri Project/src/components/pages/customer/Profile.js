import React, { Component } from 'react';
import {MDBRow } from 'mdbreact';
import Info from './Info';
import PasswordBox from './PasswordBox';

class Profile extends Component {
    state = {}
    render() {
        return (
            <MDBRow className="mt-4">
                <Info/>
                <PasswordBox/>
            </MDBRow>
        );
    }
}

export default Profile;