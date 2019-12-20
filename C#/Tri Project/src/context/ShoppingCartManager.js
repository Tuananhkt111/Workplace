import JwtDecode from "jwt-decode";

class ShoppingCartManager {
    _shoppingCart = JSON.parse(localStorage.getItem("cart"))
    total = 0
    numberProducts = 0
    ShoppingCartManager() { }

    addToCart(product) {
        if (this._shoppingCart === null) {
            this._shoppingCart = {
                UserId: JwtDecode(localStorage.getItem('token')).unique_name,
                Items: []
            };
        }
        var check = false;
        this._shoppingCart.Items.map((item) => {
            if (item.ProductId === product.ProductId) {
                item.Quantity++
                check = true;
            }
            return item
        })
        if (!check) {
            this._shoppingCart.Items = [product, ...this._shoppingCart.Items]
        }
        localStorage.setItem("cart", JSON.stringify(this._shoppingCart))
    }
    updateCart(product) {
        if (this._shoppingCart === null) {
            return
        }
        this._shoppingCart.Items.map((item) => {
            if (item.ProductId === product.ProductId) {
                if (product.Quantity > 0) {
                    item.Quantity = product.Quantity
                } else {
                    item.Quantity = 1
                }
            }
            return item
        })
        localStorage.setItem("cart", JSON.stringify(this._shoppingCart))
    }
    removeItem(id) {
        if (this._shoppingCart === null) {
            return
        }
        this._shoppingCart.Items = this._shoppingCart.Items.filter((item) => {
            return item.ProductId !== id
        })
        localStorage.setItem("cart", JSON.stringify(this._shoppingCart))
    }
    getSubTotal() {
        if (this._shoppingCart === null) {
            return 0
        }
        this.total = 0
        this._shoppingCart.Items.map((item) => {
            this.total += item.Price * item.Quantity
            return item
        })
        return this.total
    }
    getNumberProducts() {
        if (this._shoppingCart === null) {
            return 0
        }
        return this._shoppingCart.Items.length
    }
}

const shoppingCartManager = new ShoppingCartManager();
export default shoppingCartManager;
