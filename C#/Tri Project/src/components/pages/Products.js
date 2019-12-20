import React, { Component } from 'react';
import { Card } from 'react-bootstrap';
import Axios from 'axios';
import { APIUrl } from '../../context/AuthContext';
import { Link } from 'react-router-dom';
import SearchBar from '../layouts/SearchBar';

class Products extends Component {
    state = {
        products: [],
        searchKey: "",
        searchSupplier: "",
        minPrice : 0,
        maxPrice : 1000000000000,
    }
    componentDidMount() {
        var url;
        if (this.props.category !== "all") {
            url = APIUrl + '/Categories/' + this.props.category;
        } else {
            url = APIUrl + '/Products';
        }
        Axios.get(url)
            .then((response) => {
                if (this.props.category !== "all") {
                    this.setState({
                        products: response.data.products
                    })
                } else {
                    this.setState({
                        products: response.data
                    })
                }
            })
            .catch(function (error) {
            });
    }

    filter = (obj) => {
        if (obj.name === "minPrice" && obj.value === "") {
            obj.value = 0
        } else if (obj.name === "maxPrice") {
            if ( obj.value === "") {
                obj.value = 1000000000000
            }
        }
        this.setState({
            [obj.name]: obj.value
        })
    }

    render() {
        return (
            <div>
                <SearchBar action={this.filter} />
                {
                    this.state.products.map((product) => {
                        if (product.productName.toLowerCase().includes(this.state.searchKey.toLowerCase())
                            && product.supplierId.includes(this.state.searchSupplier)
                            && product.price >= this.state.minPrice && product.price <= this.state.maxPrice) {
                            return <Card key={product.productId} style={{ width: '14rem' }} className="float-left ml-4 mr-4 mt-4">
                                <Card.Img style={{ height: '14rem' }} variant="top" src={"https://localhost:44321/images/" + product.picture} />
                                <Card.Body style={{ height: '8rem' }}>
                                    <Card.Title >{product.productName}</Card.Title>
                                </Card.Body>
                                <Card.Body>
                                    <Card.Text>{product.price} VND</Card.Text>
                                    <Card.Text className="font-weight-bold">{product.supplier.supplierName}</Card.Text>
                                    <Card.Link as={Link} to={"/productDetail/" + product.productId}>Detail</Card.Link>
                                </Card.Body>
                            </Card>
                        }
                        return <div key={product.productId}></div>
                    })
                }
            </div>
        )
    }
}

export default Products;