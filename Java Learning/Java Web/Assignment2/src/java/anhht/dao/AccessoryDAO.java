/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dao;

import anhht.db.MyConnection;
import anhht.dto.AccessoryDTO;
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
public class AccessoryDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AccessoryDAO() {
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

    public List<AccessoryDTO> findByBrandNotDelete(String search) throws Exception {
        List<AccessoryDTO> result = null;
        AccessoryDTO dto = null;
        try {
            String sql = "select AccessoryID, AccessoryName, Brand, Description, Price, isDelete from tbl_Accessories where isDelete = ? and Brand like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(2, "%" + search + "%");
            preStm.setBoolean(1, false);
            result = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("AccessoryID");
                String name = rs.getString("AccessoryName");
                String brand = rs.getString("Brand");
                String descrition = rs.getString("Description");
                float price = rs.getFloat("Price");
                boolean isDelete = rs.getBoolean("isDelete");
                dto = new AccessoryDTO(id, name, brand, descrition, price, isDelete);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean update(AccessoryDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_Accessories set AccessoryName = ?,Brand = ?, Description = ?, Price = ?, isDelete = ? where AccessoryID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getBrand());
            preStm.setFloat(4, dto.getPrice());
            preStm.setString(3, dto.getDescription());
            preStm.setBoolean(5, dto.isIsDelete());
            preStm.setString(6, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(AccessoryDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_Accessories values(?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getBrand());
            preStm.setFloat(5, dto.getPrice());
            preStm.setString(4, dto.getDescription());
            preStm.setBoolean(6, dto.isIsDelete());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from tbl_Accessories where AccessoryID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public AccessoryDTO findByPrimaryKey(String id) throws Exception {
        AccessoryDTO dto = null;
        try {
            String sql = "select AccessoryName, Brand, Price, Description, isDelete from tbl_Accessories where AccessoryID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("AccessoryName");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                String brand = rs.getString("Brand");
                boolean isDelete = rs.getBoolean("isDelete");
                dto = new AccessoryDTO(id, name, brand, description, price, isDelete);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
