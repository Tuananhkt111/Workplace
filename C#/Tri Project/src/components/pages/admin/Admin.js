import React, { Component } from 'react';
import { MDBNav, MDBNavLink } from 'mdbreact';
import { Route } from 'react-router';
import ProductManager from './ProductManager';
import UserManager from './UserManager';
class Admin extends Component {
    state = {  }
    render() { 
        return ( 
            <React.Fragment>
                <MDBNav color="">
                <MDBNavLink to="/admin/product">Product</MDBNavLink>
                <MDBNavLink to="/admin/user">User</MDBNavLink>
            </MDBNav>
            <Route exact path="/admin/product" component={ProductManager}/>
            <Route exact path="/admin/user" component={UserManager}/>
            </React.Fragment>
         );
    }
}
 
export default Admin;