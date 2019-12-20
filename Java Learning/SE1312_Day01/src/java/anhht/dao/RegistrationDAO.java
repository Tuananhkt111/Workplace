/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dao;

import anhht.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tuana
 */
public class RegistrationDAO implements Serializable {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public RegistrationDAO() {
    }
    
    public void closeConnection() {
        try {
            if(rs != null) {
                rs.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String checkLogin(String username, String password) {
        String role = "failed";
        try {
            String sql = "select Role from Registration where Username = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }
}
