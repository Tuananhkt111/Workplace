import React, { Component } from 'react';
import { MDBNav, MDBNavLink } from 'mdbreact';

class CategoriesNav extends Component {
    state = {
    }
    
    render() {
        return (
            <MDBNav color="amber">
                <MDBNavLink to="/">All</MDBNavLink>
                {this.props.categories.map((category) => {
                    return <MDBNavLink key={category.categoryId} to={"/" + category.categoryId}>{category.categoryName}</MDBNavLink>
                })}
            </MDBNav>
        );
    }
}

export default CategoriesNav;