import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import NavMenu from './components/layouts/NavMenu';
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

import { Route } from 'react-router';
import Login from './components/pages/Login';
import Register from './components/pages/Register';
import Error from './components/pages/Error';
import CategoriesNav from './components/pages/CategoriesNav';
import Products from './components/pages/Products';
import Axios from 'axios';
import { APIUrl } from './context/AuthContext';
import Admin from './components/pages/admin/Admin';
import Product from './components/pages/Product';
import ShoppingCart from './components/pages/ShoppingCart';
import Profile from './components/pages/customer/Profile';
class App extends Component {
  state = {
    categories: []
  }
  componentDidMount() {
    Axios.get(APIUrl + '/categories')
      .then((response) => {
        this.setState({
          categories: response.data
        })
      })
      .catch(function (error) {
      });
  }
  render() {
    return (
      <Container>
        <NavMenu />
        <CategoriesNav categories={this.state.categories} />
        <Route exact path="/" component={() => <Products category="all"/>} />
        {this.state.categories.map(category => {
          return <Route key={category.categoryId} 
          path={"/" + category.categoryId} 
        component={() => <Products category={category.categoryId}/>} />
        })}
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/error" component={Error} />    
        <Route path="/admin" component={Admin}/>   
        <Route path="/productDetail" component={Product}/>
        <Route path="/cart" component={ShoppingCart}/>
        <Route path="/profile" component={Profile}/>
      </Container>
    );
  }
}

export default App;
