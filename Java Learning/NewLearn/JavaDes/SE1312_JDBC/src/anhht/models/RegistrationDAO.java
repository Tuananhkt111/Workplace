/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.models;

import anhht.db.MyConnection;
import anhht.dto.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuana
 */
public class RegistrationDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public RegistrationDAO() {
    }

    public List<RegistrationDTO> findByName(String search) {
        List<RegistrationDTO> result = null;
        String username = null;
        String fullname = null;
        String role = null;
        RegistrationDTO dto = null;
        try {
            //1. + //2
            conn = MyConnection.getMyConnection();
            //3.
            String sql = "Select username, fullname, role from MainTable "
                    + "where fullname LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            //4.
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                dto = new RegistrationDTO(username, fullname, role);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.Dong ket noi
            closeConnection();
        }
        return result;

    }

    public RegistrationDTO findByPrimaryKey(String key) {
        RegistrationDTO dto = null;
        try {
            //1 + //2
            conn = MyConnection.getMyConnection();
            //3.nhap sql truy van
            String sql = "Select Fullname, Role From"
                    + " MainTable where username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Xu li ket qua
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                dto = new RegistrationDTO(key, fullname, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.Dong ket noi
            closeConnection();
        }
        return dto;
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            //1 + //2
            conn = MyConnection.getMyConnection();
            //3 Truy van
            String sql = "Insert into MainTable(Username, "
                    + "Password, Fullname, Role) values(?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            //1 + //2
            conn = MyConnection.getMyConnection();
            //3 Truy van
            String sql = "update MainTable set Password = ?, Fullname = ?, Role = ? where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getUsername());
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            //4. Xu li ket qua
            check = preStm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5. Dong ket noi
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "delete from MainTable where UserName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
