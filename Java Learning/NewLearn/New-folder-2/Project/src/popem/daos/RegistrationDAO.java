/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import popem.db.MyConnection;

/**
 *
 * @author popem
 */
public class RegistrationDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public String findByUsernameAndPassword(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Role "
                    + "from Account "
                    + "where username = ? and password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next())
                role = rs.getString("Role");
        } finally {
            closeConnection();
        }
        return role;
    }
    
    public String findExisting(String username) throws Exception {
        String role = "";
        try {
            String sql = "Select Role "
                    + "from Account "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next())
                role = rs.getString("Role");
        } finally {
            closeConnection();
        }
        return role;
    }
    
    public boolean create(String username, String password) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Account "
                    + "(username,password,role) values (?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            preStm.setString(3, "user");
            check = preStm.executeUpdate()> 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
