import React, { Component } from 'react';
import { MDBRow, MDBCol, MDBCard, MDBCardBody, MDBBtn, MDBCardTitle, MDBCardText, MDBInput, MDBAlert } from 'mdbreact';
import Axios from 'axios';
import authContext, { APIUrl } from '../../context/AuthContext';
import JwtDecode from 'jwt-decode';
import shoppingCartManager from '../../context/ShoppingCartManager';
class Product extends Component {
    state = {

    }
    constructor(props) {
        super(props);
        this.state = {
            product: {
                productId: "",
                productName: "",
                price: 0,
                productDescription: "",
                supplierId: "",
                categoryId: "",
                status: true,
                quantity: 10,
                picture: "",
                screen: "",
                operatingSystem: "",
                rearCamera: "",
                frontCamera: "",
                cpu: "",
                ram: "",
                internalMemory: "",
                sim: "",
                batteryCapacity: ""
            },
            role: "",
            status: "",
            number: 0
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    componentDidMount() {
        this.setState({
            number: shoppingCartManager.getNumberProducts()
        })
        var path = window.location.pathname;
        var id = path.substring(path.lastIndexOf("/") + 1)
        Axios.get(APIUrl + '/Products/' + id)
            .then((response) => {
                this.setState({
                    product: response.data
                })
            })
            .catch(function (error) {
            });
        var token = authContext.getToken();
        if (token != null) {
            var decoded = JwtDecode(token);
            this.setState({
                role: decoded.role
            })
        } else {
            this.setState({
                role: ""
            })
        }
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
        if (name === "price" && (target.value === '')) {
            target.value = 0
        }
        if (name === "quantity" && (target.value === '')) {
            target.value = 10
        }
        t[name] = parseFloat(target.value);
        this.setState({
            product: t,
            ...this.state
        });
    }
    handleClick = () => {
        shoppingCartManager.addToCart({
            ProductId: this.state.product.productId,
            Price: this.state.product.price,
            Quantity: 1
        })
        this.setState({
            number: shoppingCartManager.getNumberProducts()
        })
    }
    handleSubmit(event) {
        var product = this.state.product;
        let data = JSON.stringify({
            ProductId: product.productId,
            ProductName: product.productName,
            Price: product.price,
            ProductDescription: product.productDescription,
            SupplierId: product.supplierId,
            CategoryId: product.categoryId,
            Status: product.status,
            Quantity: product.quantity,
            Picture: product.picture,
            Screen: product.screen,
            OperatingSystem: product.operatingSystem,
            RearCamera: product.rearCamera,
            FrontCamera: product.frontCamera,
            CPU: product.cpu,
            RAM: product.ram,
            InternalMemory: product.internalMemory,
            SIM: product.sim,
            BatteryCapacity: product.batteryCapacity
        })
        Axios.put(APIUrl + '/Products/' + product.productId, data, {
            headers: {
                'Authorization': 'bearer ' + localStorage.getItem("token"),
                'Content-Type': 'application/json'
            }
        })
            .then((response) => {
                if (response.status === 204) {
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
    handleAlternate(event) {
        Axios
            .delete(APIUrl + "/Products/" + this.state.product.productId, {
                headers: {
                    'Authorization': 'bearer ' + localStorage.getItem("token")
                }
            })
            .then(res => {
                if (res.status === 204) {
                    this.setState({
                        status: "success"
                    });
                    window.location.replace("/");
                }
            })
            .catch(err => {
                this.setState({
                    status: "fail"
                })
            });
        event.preventDefault();
    }
    render() {
        return (
            <MDBRow className="mt-5 position-relative">
                <MDBCol md="5" className="fixed-top position-relative">
                    <figure>
                        <img
                            src={"https://localhost:44321/images/ip.jpg"}
                            alt="Gallery"
                            className="img-fluid"
                        />
                    </figure>
                    <p>
                        {this.state.product.productDescription}
                    </p>
                </MDBCol>
                <MDBCol className="ml-5">
                    {this.state.role === 'Admin' ? this.admin() : this.customer()}
                </MDBCol>
            </MDBRow>
        );
    }
    admin = () => {
        return <MDBCard>
            <MDBCardBody >
                <MDBCardTitle className="font-weight-bold">Details</MDBCardTitle>
                <MDBCardTitle className="h2 font-weight-bold text-info">{this.state.product.productId}</MDBCardTitle>
                <form onSubmit={this.handleSubmit}>
                    <MDBInput
                        value={this.state.product.productName}
                        onChange={this.handleChange}
                        name="productName"
                        label="Product Name"
                        icon="envelope"
                        group
                        type="text"
                        validate
                        required
                    />
                    <MDBInput
                        value={this.state.product.productDescription}
                        onChange={this.handleChange}
                        name="productDescription"
                        label="Description"
                        icon="user"
                        group
                        type="text"
                        required
                    />
                    <MDBInput
                        value={this.state.product.price}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                        name="price"
                        label="Price"
                        icon="user"
                        group
                        type="number"
                        required
                    />
                    <MDBInput
                        value={this.state.product.categoryId}
                        onChange={this.handleChange}
                        name="categoryId"
                        label="Category"
                        icon="user"
                        group
                        type="text"
                        required
                    />
                    <MDBInput
                        value={this.state.product.supplierId}
                        onChange={this.handleChange}
                        name="supplierId"
                        label="Supplier"
                        icon="user"
                        group
                        type="text"
                        required
                    />
                    <MDBInput
                        value={this.state.product.quantity}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                        name="quantity"
                        label="Quantity"
                        icon="user"
                        group
                        type="number"
                        required
                    />
                    <MDBInput
                        value={this.state.product.picture}
                        onChange={this.handleChange}
                        name="picture"
                        label="Picture"
                        icon="user"
                        group
                        type="text"
                        required
                    />
                    <MDBInput
                        value={this.state.product.screen}
                        onChange={this.handleChange}
                        name="screen"
                        label="Screen"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.operatingSystem}
                        onChange={this.handleChange}
                        name="operatingSystem"
                        label="Operating"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.frontCamera}
                        onChange={this.handleChange}
                        name="frontCamera"
                        label="Front camera"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.rearCamera}
                        onChange={this.handleChange}
                        name="rearCamera"
                        label="Rear camera"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.cpu}
                        onChange={this.handleChange}
                        name="cpu"
                        label="CPU"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.ram}
                        onChange={this.handleChange}
                        name="ram"
                        label="RAM"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.internalMemory}
                        onChange={this.handleChange}
                        name="internalMemory"
                        label="Internal Memory"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.sim}
                        onChange={this.handleChange}
                        name="sim"
                        label="Sim"
                        icon="user"
                        group
                        type="text"
                    />
                    <MDBInput
                        value={this.state.product.batteryCapacity}
                        onChange={this.handleChange}
                        name="batteryCapacity"
                        label="Battery capacity"
                        icon="user"
                        group
                        type="text"
                    />
                    {this.state.status === "fail" ?
                        <MDBAlert color="danger">
                            Action failed
                                    </MDBAlert>
                        : <div></div>
                    }
                    {this.state.status === "success" ?
                        <MDBAlert color="success">
                            Action succeed
                                    </MDBAlert>
                        : <div></div>
                    }
                    <MDBBtn type="submit">Update</MDBBtn>
                    <MDBBtn onClick={this.handleAlternate.bind(this)} color="deep-orange">Delete</MDBBtn>
                </form>
            </MDBCardBody>
        </MDBCard>
    }
    customer = () => {
        return <MDBCard>
            <MDBCardBody px="5">
                <MDBCardTitle className="font-weight-bold">Details</MDBCardTitle>
                <MDBCardTitle className="h2 font-weight-bold text-info">{this.state.product.productName}</MDBCardTitle>
                <MDBCardText><b>Screen</b>: {this.state.product.screen}</MDBCardText>
                <MDBCardText><b>Operating system</b>: {this.state.product.operatingSystem}</MDBCardText>
                <MDBCardText><b>Rear camera</b>: {this.state.product.rearCamera}</MDBCardText>
                <MDBCardText><b>Front camera</b>: {this.state.product.frontCamera}</MDBCardText>
                <MDBCardText><b>CPU</b>: {this.state.product.cpu}</MDBCardText>
                <MDBCardText><b>RAM</b>: {this.state.product.ram}</MDBCardText>
                <MDBCardText><b>Internal Memory</b>: {this.state.product.internalMemory}</MDBCardText>
                <MDBCardText><b>Sim</b>: {this.state.product.sim}</MDBCardText>
                <MDBCardText><b>Battery capacity</b>: {this.state.product.batteryCapacity}</MDBCardText>
                <MDBCardText ><b>{this.state.product.price} VND</b></MDBCardText>
                {this.state.role === "Customer"
                    ? <MDBBtn
                        onClick={this.handleClick}
                        className="float-right">
                        Add to cart ({this.state.number})
                </MDBBtn>
                    : <MDBBtn className="float-right" disabled>Add to cart</MDBBtn>}
            </MDBCardBody>
        </MDBCard>
    }
}

export default Product;