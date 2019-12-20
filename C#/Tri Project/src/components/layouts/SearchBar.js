import React, { Component } from 'react';
import { MDBRow, MDBCol, MDBInput } from 'mdbreact';
import Axios from 'axios';
import { APIUrl } from '../../context/AuthContext';

class SearchBar extends Component {
    state = {
        suppliers: []
    }
    componentDidMount() {
        Axios.get(APIUrl + "/suppliers")
            .then((response) => {
                this.setState({
                    suppliers: response.data
                })
            })
            .catch((error) => {

            });
    }
    render() {
        return (
            <MDBRow className="mt-2">
                <MDBCol md="5">
                    <MDBInput onChange={(event) => this.props.action({ name: "searchKey", value: event.target.value })} hint="Search" type="text" containerClass="mt-0" />
                </MDBCol>
                <MDBCol md="3">
                    <select className="browser-default custom-select" onChange={(event) => this.props.action({ name: "searchSupplier", value: event.target.value })}>
                        <option value="">Supplier</option>
                        {this.state.suppliers.map((supplier) => {
                            return <option key={supplier.supplierId} value={supplier.supplierId}>{supplier.supplierName}</option>
                        })}
                    </select>
                </MDBCol>
                <MDBCol md="3">
                    <div>
                        <MDBRow>
                            <MDBCol>
                                <MDBInput onChange={(event) => this.props.action({ name: "minPrice", value: event.target.value })} hint="Min price" type="number" min="0" containerClass="mt-0" />
                            </MDBCol>
                            <MDBCol>
                                <MDBInput onChange={(event) => this.props.action({ name: "maxPrice", value: event.target.value })} hint="Max price" type="number" min="0" containerClass="mt-0" />
                            </MDBCol>
                        </MDBRow>
                    </div>
                </MDBCol>
            </MDBRow>
        );
    }
}

export default SearchBar;