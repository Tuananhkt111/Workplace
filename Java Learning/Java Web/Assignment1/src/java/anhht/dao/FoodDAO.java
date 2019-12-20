/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dao;

import anhht.db.MyConnection;
import anhht.dto.FoodDTO;
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
public class FoodDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public FoodDAO() {
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
    
    public List<FoodDTO> findByPriceRangeAvailable(float min, float max) throws Exception {
        List<FoodDTO> result = null;
        FoodDTO dto = null;
        try {
            String sql = "select FoodID, FoodName, Price, Description, Type, Status from tbl_Food where Price >= ? and Price <= ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setFloat(1, min);
            preStm.setFloat(2, max);
            preStm.setString(3, "Available");
            result = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {                
                String id = rs.getString("FoodID");
                String name = rs.getString("FoodName");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                String type = rs.getString("Type");
                String status = rs.getString("Status");
                dto = new FoodDTO(id, name, description, type, status, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean update(FoodDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_Food set FoodName = ?, Price = ?, Description = ?, Type = ?, Status = ? where FoodID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setFloat(2, dto.getPrice());
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getType());
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insert(FoodDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_Food values(?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getType());
            preStm.setString(6, dto.getStatus());            
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from tbl_Food where FoodID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);          
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public FoodDTO findByPrimaryKey(String id) throws Exception {
        FoodDTO dto = null;
        try {
            String sql = "select FoodName, Price, Description, Type, Status from tbl_Food where FoodID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()) {
                String name = rs.getString("FoodName");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                String type = rs.getString("Type");
                String status = rs.getString("Status");
                dto = new FoodDTO(id, name, description, type, status, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
