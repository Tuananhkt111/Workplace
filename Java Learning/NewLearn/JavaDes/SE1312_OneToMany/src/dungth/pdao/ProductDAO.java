/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.pdao;

import dungth.db.MyConnection;
import dungth.dto.CategoryDTO;
import dungth.pdto.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Dung
 */
public class ProductDAO implements Serializable{
    
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public ProductDAO(){
        
    }
    private void closeConnection() throws Exception {
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

    public List<ProductDTO> loadProductsByCategoryID(String cateID) throws Exception {
        List<ProductDTO> result = null;
        String id = null;
        String name = null;
        int quantity = 0;
        ProductDTO dto = null;
        try {
            String sql = "Select ProductID, Name, Quantity From tbl_Product Where CateID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cateID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {

                id = rs.getString("ProductId");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                dto = new ProductDTO(id, name, quantity);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public ProductDTO findByPrimaryKey(String key) throws Exception{
        ProductDTO dto = null;
        try {
            String sql = "Select Name, Description, Quantity, CateID From tbl_Product "
                    + "Where ProductID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if(rs.next()) {
                String name = rs.getString("Name");
                String des = rs.getString("Description");
                int quantity = rs.getInt("Quantity");
                String cateID = rs.getString("CateID");
                dto = new ProductDTO(key, name, quantity);
                dto.setCateID(cateID);
                dto.setDes(des);
            }
        }  finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From tbl_Product Where ProductID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean deleteAllByCateID(String cateID) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From tbl_Product Where CateID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cateID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insert(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_Product (ProductID, Name, Quantity, Description, "
                    + "CateID) values(?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setInt(3, dto.getQuantity());
            preStm.setString(4, dto.getDes());
            preStm.setString(5, dto.getCateID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
