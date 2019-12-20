/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import popem.db.MyConnection;
import popem.dtos.InventoryDTO;

/**
 *
 * @author popem
 */
public class InventoryDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public List<InventoryDTO> findByUsername(String username) throws Exception{
        List<InventoryDTO> list = null;
        try {
            String sql = " Select Item , Quantity from Inventory "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                list.add(new InventoryDTO(rs.getString("Item"), rs.getInt("Quantity")));
            }
        } finally  {
            closeConnection();
        }
        return list;
    }
    
    public InventoryDTO findByPrimaryKey(String username, String item) throws Exception{
        InventoryDTO dto = null;
        try {
            String sql = " Select Quantity from Inventory "
                    + "where username = ? and Item = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, item);
            rs = preStm.executeQuery();
            if (rs.next()){
                dto = new InventoryDTO(username, item, rs.getInt("Quantity"));
            }
        } finally  {
            closeConnection();
        }
        return dto;
    }
    
    public boolean update(InventoryDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Inventory "
                    + "set Quantity = ? "
                    + "where username = ? and item = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getQuantity());
            preStm.setString(2, dto.getUsername());
            preStm.setString(3, dto.getItem());
            check = preStm.executeUpdate()> 0 ;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean create(InventoryDTO dto) throws Exception{
        boolean check = false;
        try{
            String sql = "Insert into Inventory "
                    + "(username, Item, Quantity) "
                    + "values (?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getItem());
            preStm.setInt(3, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String username, String item) throws Exception{
        boolean check = false;
        try {
            String sql = "Delete from Inventory "
                    + "where username = ? and Item = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, item);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteAll(String username) throws Exception{
        boolean check = false;
        try {
            String sql = "Delete from Inventory "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
