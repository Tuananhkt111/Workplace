export const APIUrl = "https://localhost:44321/api";
var jwtDecode = require('jwt-decode');
export class AuthContext {
    getRole() {
        var token = localStorage.getItem("Token");
        var role;
        if (token != null) {
            var decoded = jwtDecode(token);
            role = decoded.role
        } else {
            role = ""
        }
        return role;
    }
    getToken() {
        var token = localStorage.getItem("token");
        return token;
    }
}

const authContext = new AuthContext();
export default authContext;

