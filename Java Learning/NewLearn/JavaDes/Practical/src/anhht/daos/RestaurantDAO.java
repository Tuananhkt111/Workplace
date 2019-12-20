/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.dtos.RestaurantDTO;
import anht.db.MyConnection;
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
public class RestaurantDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
    }
    
    public boolean update(RestaurantDTO resDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update tbl_Restaurant set RestaurantName = ?, "
                    + "Address = ?, District = ?, isDelete = ? where RestaurantID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, resDTO.getName());
            preStm.setString(2, resDTO.getAddress());            
            preStm.setString(3, resDTO.getDistrict());
            preStm.setBoolean(4, resDTO.isIsDelete());
            preStm.setString(5, resDTO.getId());
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(RestaurantDTO resDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "delete from tbl_Restaurant where RestaurantID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, resDTO.getId());
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RestaurantDTO> findAllByDistrict(String district) {
        List<RestaurantDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select RestaurantID, RestaurantName, Address,"
                    + " District, isDelete from tbl_Restaurant where district = ? and isDelete = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, district);
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("RestaurantID");
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                boolean isDelete = rs.getBoolean("isDelete");
                list.add(new RestaurantDTO(id, name, address, district, isDelete));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public RestaurantDTO findByPrimaryKey(String key) {
        RestaurantDTO resDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select RestaurantID, RestaurantName, Address,"
                    + " District, isDelete from tbl_Restaurant where RestaurantID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("RestaurantID");
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String district = rs.getString("District");
                boolean isDelete = rs.getBoolean("isDelete");
                resDTO = new RestaurantDTO(id, name, address, district, isDelete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resDTO;
    }
}
