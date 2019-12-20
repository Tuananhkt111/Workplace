/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        if(rs != null) {
            rs.close();
        }
        if(preStm != null) {
            preStm.close();
        }
        if(conn != null) {
            conn.close();
        }
    }
    
    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "select Role from Registration where Username = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }
    
    public ArrayList<RegistrationDTO> search(String search) throws Exception {
        ArrayList<RegistrationDTO> list = null;
        RegistrationDTO dto = null;
        try {
            String sql = "select Username, Fullname, Role from Registration where Fullname like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                dto = new RegistrationDTO(username, fullname, role);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from Registration where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean insert(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into Registration values (?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getUsername());
            preStm.setString(4, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
