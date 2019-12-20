/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dao;

import dungth.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tuana
 */
public class RegistrationDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public RegistrationDAO() {
    }

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        String sql = "select Role from Registration where Username = ? and Password = ?";
        conn = MyConnection.getMyConnection();
        preStm = conn.prepareStatement(sql);
        preStm.setString(1, username);
        preStm.setString(2, password);
        rs = preStm.executeQuery();
        if(rs.next()) {
            role = rs.getString("Role");
        }
        return role;
    }
}
