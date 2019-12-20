/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.role;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class RoleDAO implements Serializable {
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
    public String loadRoleByID(String roleID) throws NamingException, SQLException {
        String result = "";
        try {
            String sql = "select RoleName from Role where RoleID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getString("RoleName");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public ArrayList<RoleDTO> loadRole() throws NamingException, SQLException {
        ArrayList<RoleDTO> list = null;
        try {
            String sql = "select RoleName, RoleID from Role";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roleID = rs.getString("RoleID");
                String roleName = rs.getString("RoleName");
                list.add(new RoleDTO(roleID, roleName));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
