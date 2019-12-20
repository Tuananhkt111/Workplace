/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.TravelTransactionDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuana
 */
public class TravelTransactionDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    
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
        } catch (SQLException ex) {
        }
    }
    
    public boolean insert(TravelTransactionDTO ttDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into TravelTransaction values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, ttDTO.getTransID());
            preStm.setString(2, ttDTO.getCusID());
            preStm.setString(3, ttDTO.getTravelID());
            preStm.setString(4, ttDTO.getCarSerial());
            preStm.setString(5, ttDTO.getEmpID());
            preStm.setTimestamp(6, ttDTO.getStartTime());
            preStm.setTimestamp(7, ttDTO.getEndTime());
            preStm.setInt(8, ttDTO.getDuration());
            preStm.setInt(9, ttDTO.getPrice());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
    
    public TravelTransactionDTO findByPrimaryKey(String key) {
        TravelTransactionDTO ttDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CusID, TravelID, CarSerial, EmpID, StartTime, "
                    + "Duration, Price from TravelTransaction where TransID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                String cusID = rs.getString("CusID");
                String travelID = rs.getString("TravelID");
                String carSerial = rs.getString("CarSerial");
                String empID = rs.getString("EmpID");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                int duration = rs.getInt("Duration");
                int price = rs.getInt("Price");
                ttDTO = new TravelTransactionDTO(key, travelID, cusID, empID, carSerial, price, duration, StartTime);
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return ttDTO;
    }
    
    public List<TravelTransactionDTO> findByCusID(String cusID) {
        List<TravelTransactionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TransID, TravelID, CarSerial, EmpID, StartTime, "
                    + "Duration, Price from TravelTransaction "
                    + "where CusID = ? order by TransID ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cusID);
            rs = preStm.executeQuery();
            //4. Handle result 
            list = new ArrayList<>();
            while (rs.next()) {
                String transID = rs.getString("TransID");
                String travelID = rs.getString("TravelID");
                String carSerial = rs.getString("CarSerial");
                String empID = rs.getString("EmpID");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                int duration = rs.getInt("Duration");
                int price = rs.getInt("Price");
                list.add(new TravelTransactionDTO(transID, travelID, cusID, empID, carSerial, price, duration, StartTime));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
    
    public boolean delete(String transID) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "delete from TravelTransaction where TransID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, transID);
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
}
