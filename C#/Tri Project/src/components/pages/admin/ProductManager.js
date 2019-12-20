import React, { Component } from 'react';
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBIcon, MDBAlert } from 'mdbreact';
import Axios from 'axios';
import { APIUrl } from '../../../context/AuthContext';

class ProductManager extends Component {
    state = {}
    constructor(props) {
        super(props);
        this.state = {
            product: {
                ProductId: "",
                ProductName: "",
                Price: 0,
                ProductDescription: "",
                SupplierId: "",
                CategoryId: "",
                Status: true,
                Quantity: 10,
                Picture: "",
                CreateDate: "",
                LastModifiedDate: "",
                Screen: "",
                OperatingSystem: "",
                RearCamera: "",
                FrontCamera: "",
                CPU: "",
                RAM: "",
                InternalMemory: "",
                SIM: "",
                BatteryCapacity: ""
            },
            status: ""
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        const target = event.target;
        const name = target.name;
        const t = this.state.product;
        if ((name === "Price" || name === "Quantity") && (target.value < 0)) {
            target.value = 0
        }
        if (name === "Price" || name === "Quantity") {
            t[name] = parseFloat(target.value);
        } else {
            t[name] = target.value
        }
        this.setState({
            product: t,
            ...this.state
        });
    }
    handleBlur = (event) => {
        const target = event.target;
        const name = target.name;
        const t = this.state.product;
        if (name === "Price" && (target.value === '')) {
            target.value = 0
        }
        if (name === "Quantity" && (target.value === '')) {
            target.value = 10
        }
        t[name] = parseFloat(target.value);
        this.setState({
            product: t,
            ...this.state
        });
    }
    handleSubmit(event) {
        var product = this.state.product;
        let data = JSON.stringify({
            ProductId: product.ProductId,
            ProductName: product.ProductName,
            Price: product.Price,
            ProductDescription: product.ProductDescription,
            SupplierId: product.SupplierId,
            CategoryId: product.CategoryId,
            Status: product.Status,
            Quantity: product.Quantity,
            Picture: product.Picture,
            Screen: product.Screen,
            OperatingSystem: product.OperatingSystem,
            RearCamera: product.RearCamera,
            FrontCamera: product.FrontCamera,
            CPU: product.CPU,
            RAM: product.RAM,
            InternalMemory: product.InternalMemory,
            SIM: product.SIM,
            BatteryCapacity: product.BatteryCapacity
        })
        Axios.post(APIUrl + '/Products', data, {
            headers: {
                'Authorization': 'bearer ' + localStorage.getItem("token"),
                'Content-Type': 'application/json'
            }
        })
            .then((response) => {
                if (response.status === 201) {
                    this.setState({
                        status: "success"
                    })
                }
            })
            .catch((error) => {
                this.setState({
                    status: "fail"
                })
            });
        event.preventDefault();
    }
    render() {
        return (
            <MDBRow center>
                <MDBCol>
                    <MDBRow center>
                        <MDBCol md="6">
                            <form onSubmit={this.handleSubmit}>
                                <p className="h5 text-center mb-4">Add product</p>
                                <div className="grey-text">
                                    <MDBInput
                                        value={this.state.product.ProductId}
                                        onChange={this.handleChange}
                                        name="ProductId"
                                        label="Product ID"
                                        group
                                        type="text"
                                        validate
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.ProductName}
                                        onChange={this.handleChange}
                                        name="ProductName"
                                        label="Product Name"
                                        icon="envelope"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.ProductDescription}
                                        onChange={this.handleChange}
                                        name="ProductDescription"
                                        label="Description"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.Price}
                                        onChange={this.handleChange}
                                        onBlur={this.handleBlur}
                                        name="Price"
                                        label="Price"
                                        icon="user"
                                        group
                                        type="number"
                                        validate
                                        error="wrong"
                                        success="right"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.CategoryId}
                                        onChange={this.handleChange}
                                        name="CategoryId"
                                        label="Category"
                                        icon="user"
                                        group
                                        type="text"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.SupplierId}
                                        onChange={this.handleChange}
                                        name="SupplierId"
                                        label="Supplier"
                                        icon="user"
                                        group
                                        type="text"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.Quantity}
                                        onChange={this.handleChange}
                                        onBlur={this.handleBlur}
                                        name="Quantity"
                                        label="Quantity"
                                        icon="user"
                                        group
                                        type="number"
                                        validate
                                        error="wrong"
                                        success="right"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.Picture}
                                        onChange={this.handleChange}
                                        name="Picture"
                                        label="Picture"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                        required
                                    />
                                    <MDBInput
                                        value={this.state.product.Screen}
                                        onChange={this.handleChange}
                                        name="Screen"
                                        label="Screen"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.OperatingSystem}
                                        onChange={this.handleChange}
                                        name="OperatingSystem"
                                        label="Operating"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.FrontCamera}
                                        onChange={this.handleChange}
                                        name="FrontCamera"
                                        label="Front camera"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.RearCamera}
                                        onChange={this.handleChange}
                                        name="RearCamera"
                                        label="Rear camera"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.CPU}
                                        onChange={this.handleChange}
                                        name="CPU"
                                        label="CPU"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.RAM}
                                        onChange={this.handleChange}
                                        name="RAM"
                                        label="RAM"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.InternalMemory}
                                        onChange={this.handleChange}
                                        name="InternalMemory"
                                        label="Internal Memory"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.SIM}
                                        onChange={this.handleChange}
                                        name="SIM"
                                        label="Sim"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                    <MDBInput
                                        value={this.state.product.BatteryCapacity}
                                        onChange={this.handleChange}
                                        name="BatteryCapacity"
                                        label="Battery capacity"
                                        icon="user"
                                        group
                                        type="text"
                                        validate
                                        error="wrong"
                                        success="right"
                                    />
                                </div>
                                {this.state.status === "fail" ?
                                    <MDBAlert color="danger">
                                        Insert failed, id has existed
                                    </MDBAlert>
                                    : <div></div>
                                }
                                {this.state.status === "success" ?
                                    <MDBAlert color="success">
                                        Create succeed
                                    </MDBAlert>
                                    : <div></div>
                                }
                                <div className="text-center">
                                    <MDBBtn outline color="secondary" type="submit">
                                        Add <MDBIcon far icon="" className="ml-1" />
                                    </MDBBtn>
                                </div>

                            </form>
                        </MDBCol>
                    </MDBRow>
                </MDBCol>

            </MDBRow>
        );
    }
}

export default ProductManager;