import React, { Component } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody, MDBRow, MDBCol, MDBBtn, MDBAlert } from 'mdbreact';
import shoppingCartManager from '../../context/ShoppingCartManager';
import Axios from 'axios';
import { APIUrl } from '../../context/AuthContext';

class ShoppingCart extends Component {
    state = {
        cart: {
            Items: []
        },
        status: "",
        subTotal: 0
    }
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }
    componentDidMount() {
        var cart = JSON.parse(localStorage.getItem("cart"))
        if (cart !== null) {
            this.setState({
                cart: cart,
                subTotal: shoppingCartManager.getSubTotal()
            })
        }
    }
    loadCart = () => {
        var cart = this.state.cart
        var count = 0
        return cart.Items.map((item) => {
            count++
            return <tr key={item.ProductId}>
                <td>{count}</td>
                <td>{item.ProductId}</td>
                <td>{item.Price}</td>
                <td>
                    <input type="number" value={item.Quantity} onChange={(event) => this.handleChange(event, item.ProductId)} />
                    <MDBBtn onClick={() => this.handleRemove(item.ProductId)} size="sm" color="danger">Remove</MDBBtn>
                </td>
                <td>{item.Price * item.Quantity}</td>
            </tr>
        })
    }
    handleChange = (event, id) => {
        shoppingCartManager.updateCart({ ProductId: id, Quantity: event.target.value })
        this.setState({
            cart: JSON.parse(localStorage.getItem("cart")),
            subTotal: shoppingCartManager.getSubTotal()
        })
    }
    handleRemove = (id) => {
        shoppingCartManager.removeItem(id)
        this.setState({
            cart: JSON.parse(localStorage.getItem("cart")),
            subTotal: shoppingCartManager.getSubTotal()
        })
    }
    confirmCart() {
        if (this._shoppingCart === null) {
            return
        }
        console.log(JSON.parse(localStorage.getItem("cart")))
        Axios.post(APIUrl + "/Shopping/Confirm",
            localStorage.getItem("cart"),
            {
                headers: {
                    'Authorization': 'bearer ' + localStorage.getItem("token"),
                    'Content-Type': 'application/json'
                }
            }).then((res) => {
                localStorage.setItem("cart", null)
                this.setState({
                    status: "success",
                    cart: {
                        Items: []
                    },
                    subTotal: 0
                })

            }).catch((err) => {
                this.setState({
                    status: "fail"
                })
            });
    }
    render() {
        return (
            <React.Fragment>
                <MDBRow center className="mt-3">
                    <h1>Your cart</h1>
                </MDBRow>
                <MDBRow className="mt-3">
                    <MDBCol>
                        <MDBTable striped>
                            <MDBTableHead>
                                <tr>
                                    <th>#</th>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                </tr>
                            </MDBTableHead>
                            <MDBTableBody>
                                {this.loadCart()}
                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>
                <MDBRow>
                    <MDBCol md="10">
                        <div className="float-right py-3"><h3>Total: {this.state.subTotal} VND</h3></div>
                    </MDBCol>
                    <MDBCol>
                        {this.state.subTotal > 0 ? <MDBBtn className="float-right" gradient="aqua" onClick={() => this.confirmCart()}>Check out</MDBBtn> : <MDBBtn className="float-right" gradient="aqua" disabled>Check out</MDBBtn>}
                    </MDBCol>
                </MDBRow>
                {this.state.status === "fail" ?
                    <MDBAlert color="danger">
                        Check out failed, some products was out of stock
                                    </MDBAlert>
                    : <div></div>
                }
                {this.state.status === "success" ?
                    <MDBAlert color="success">
                        Checked out
                                    </MDBAlert>
                    : <div></div>
                }
            </React.Fragment>
        );
    }
}

export default ShoppingCart;