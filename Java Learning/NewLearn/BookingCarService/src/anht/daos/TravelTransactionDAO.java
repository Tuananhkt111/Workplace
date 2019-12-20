/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.daos;

import anht.db.MyConnection;
import anht.dtos.TravelTransactionDTO;
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
            ex.printStackTrace();
        }
    }
    
    public boolean insert(TravelTransactionDTO ttDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into TravelTransaction (TransID, AccID, TravelID, CarName, StartTime, "
                    + "Duration, Price, Status) values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, ttDTO.getTransID());
            preStm.setString(2, ttDTO.getAccID());
            preStm.setString(3, ttDTO.getTravelID());
            preStm.setString(4, ttDTO.getCarName());
            preStm.setTimestamp(5, new Timestamp(ttDTO.getStartTime().getTime()));
            preStm.setInt(6, ttDTO.getDuration());
            preStm.setInt(7, ttDTO.getPrice());
            preStm.setString(8, ttDTO.getStatus());
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public List<TravelTransactionDTO> findByAccID(String accID) {
        List<TravelTransactionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TransID, TravelID, CarSerial, CarName, EmpID, StartTime, "
                    + "Duration, Price, Status from TravelTransaction "
                    + "where AccID = ? order by TransID ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, accID);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String transID = rs.getString("TransID");
                String travelID = rs.getString("TravelID");
                String carSerial = rs.getString("CarSerial");
                String carName = rs.getString("CarName");
                String empID = rs.getString("EmpID");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                int duration = rs.getInt("Duration");
                int price = rs.getInt("Price");
                String status = rs.getString("Status");
                list.add(new TravelTransactionDTO(transID, travelID, accID, empID, carSerial, carName, status, price, duration, StartTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return check;
    }
}
