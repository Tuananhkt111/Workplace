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
import java.util.Date;
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

    public AccountDTO checkLogin(String email, String password) throws NamingException, SQLException {
        AccountDTO dto = null;
        try {
            String sql = "SELECT RoleID, Name FROM Account WHERE Email = ? AND Password = ? AND Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            preStm.setString(2, password);
            preStm.setString(3, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                dto = new AccountDTO();
                dto.setRoleID(rs.getString("RoleID"));
                dto.setName(rs.getString("Name"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean insert(AccountDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "insert into Account (Email, Name, Password, Phone, Address, RoleID, Status, DateCreated) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEmail());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getAddress());
            preStm.setString(6, dto.getRoleID());
            preStm.setString(7, "Active");
            preStm.setDate(8, new java.sql.Date(new Date().getTime()));
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
