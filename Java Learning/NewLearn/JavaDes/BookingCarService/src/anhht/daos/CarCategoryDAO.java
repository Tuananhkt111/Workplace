/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.CarCategoryDTO;
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
public class CarCategoryDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public void closeConnection() {
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
        }
    }
    
    public CarCategoryDTO findByPrimaryKey(int key) {
        CarCategoryDTO ccDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select SurchargeHr, Discount"
                    + " from CarCategory where NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                int surchargeHr = rs.getInt("SurchargeHr");
                float discount = rs.getFloat("Discount");
                ccDTO = new CarCategoryDTO(key, surchargeHr, discount);
            }
        } catch (Exception e) {
        } finally {
            //5.Close connection
            closeConnection();
        }
        return ccDTO;
    }
    
    public List<CarCategoryDTO> findAll() {
        List<CarCategoryDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select NumberOfSeats, SurchargeHr, Discount"
                    + " from CarCategory order by NumberOfSeats ASC";
            preStm = conn.prepareStatement(sql);            
            rs = preStm.executeQuery();
            //4.Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                int seats = rs.getInt("NumberOfSeats");
                int surchargeHr = rs.getInt("SurchargeHr");
                float discount = rs.getFloat("Discount");
                list.add(new CarCategoryDTO(seats, surchargeHr, discount));
            }
        } catch (Exception e) {
        } finally {
            //5.Close connection
            closeConnection();
        }
        return list;
    }
    
    public boolean delete(int seats) {
        boolean check = false;
        try {
            //1 + //2
            conn = MyConnection.getMyConnection();
            //3.Input sql query
            String sql = "delete from CarCategory where NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, seats);
            //4.Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5.Close connection
            closeConnection();
        }
        return check;
    }
    
     public boolean insert(CarCategoryDTO ccDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into CarCategory values "
                    + "(?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ccDTO.getNumberOfSeats());
            preStm.setInt(2, ccDTO.getSurchargeHr());
            preStm.setFloat(3, ccDTO.getDiscount());
            //4.Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //Close connection
            closeConnection();
        }
        return check;
    }
    
    public boolean findExisting(int key) {
        boolean result = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select NumberOfSeats from CarCategory "
                    + "where NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                result = true;
            }
        }  catch (Exception e) {
        }finally {
            //Close connection
            closeConnection();
        }
        return result;
    }
    
    public boolean update(CarCategoryDTO carCatDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update CarCategory set SurchargeHr = ?, Discount = ? where NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, carCatDTO.getSurchargeHr());
            preStm.setFloat(2, carCatDTO.getDiscount());
            preStm.setInt(3, carCatDTO.getNumberOfSeats());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //5.Close connection
            closeConnection();
        }
        return check;
    }
    
}
