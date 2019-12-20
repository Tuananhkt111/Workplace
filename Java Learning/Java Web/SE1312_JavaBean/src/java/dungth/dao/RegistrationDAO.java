/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.dao;

import dungth.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hoang Dung
 */
public class RegistrationDAO implements Serializable {

    public RegistrationDAO() {
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        String sql = "Select Role From Registration Where Username = ? and Password = ?";
        try (
                Connection conn = MyConnection.getMyConnection();
                PreparedStatement preStm = conn.prepareStatement(sql); 
                //nhung thu dat trong dau () se duoc dong lai theo thu tu nguoc voi thu tu mo
                ) {
            preStm.setString(1, username);
            preStm.setString(2, password);
            try (ResultSet rs = preStm.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("Role");
                }
            }
        }
        return role;
    }
}
