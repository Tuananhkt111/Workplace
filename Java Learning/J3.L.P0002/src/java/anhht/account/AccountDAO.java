/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.account;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class AccountDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public void closeConnection() throws SQLException {
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

    public AccountDTO checkLogin(String userID, String password) throws NamingException, SQLException {
        AccountDTO dto = null;
        try {
            String sql = "SELECT RoleID, Username FROM Account WHERE UserID = ? AND Password = ? AND Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, password);
            preStm.setString(3, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                dto = new AccountDTO();
                dto.setRoleID(rs.getString("RoleID"));
                dto.setUsername(rs.getString("Username"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean insert(AccountDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "insert into Account (UserID, UserName, Password, Email, Phone, Address, RoleID, Status) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserID());
            preStm.setString(2, dto.getUsername());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getAddress());
            preStm.setString(7, dto.getRoleID());
            preStm.setString(8, "Active");
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
