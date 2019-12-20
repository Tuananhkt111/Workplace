/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.daos;

import anht.db.MyConnection;
import anht.dtos.TravelPriceDTO;
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
public class TravelPriceDAO implements Serializable {

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
            e.printStackTrace();
        }
    }

    public TravelPriceDTO findByPrimaryKey(String key) {
        TravelPriceDTO tpDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID, Destination, LimitTime, EstDistance"
                    + ", NumberOfSeats, Price from TravelPrice where TravelID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("TravelID");
                String des = rs.getString("Destination");
                int limitTime = rs.getInt("LimitTime");
                int estDistance = rs.getInt("EstDistance");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                int price = rs.getInt("Price");
                tpDTO = new TravelPriceDTO(id, des, limitTime, estDistance, numberOfSeats, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return tpDTO;
    }

    public List<TravelPriceDTO> findAll() {
        List<TravelPriceDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID, Destination, LimitTime, EstDistance"
                    + ", NumberOfSeats, Price from TravelPrice";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("TravelID");
                String des = rs.getString("Destination");
                int limitTime = rs.getInt("LimitTime");
                int estDistance = rs.getInt("EstDistance");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                int price = rs.getInt("Price");
                list.add(new TravelPriceDTO(id, des, limitTime, estDistance, numberOfSeats, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean delete(String id) {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "delete from TravelPrice where TravelID = ?";
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

    public boolean update(TravelPriceDTO tpDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update TravelPrice set Destination = ?, LimitTime = ?, "
                    + "EstDistance = ?, NumberOfSeats = ?, Price = ? where TravelID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tpDTO.getDestination());
            preStm.setInt(2, tpDTO.getLimitTime());
            preStm.setInt(3, tpDTO.getEstDistance());
            preStm.setInt(4, tpDTO.getNumberOfSeats());
            preStm.setInt(5, tpDTO.getPrice());
            preStm.setString(6, tpDTO.getId());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<TravelPriceDTO> findBySeats(int seats) {
        List<TravelPriceDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID, Destination, LimitTime, EstDistance"
                    + ", NumberOfSeats, Price from TravelPrice "
                    + "where NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, seats);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("TravelID");
                String des = rs.getString("Destination");
                int limitTime = rs.getInt("LimitTime");
                int estDistance = rs.getInt("EstDistance");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                int price = rs.getInt("Price");
                list.add(new TravelPriceDTO(id, des, limitTime, estDistance, numberOfSeats, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<TravelPriceDTO> findByDestination(String destination) {
        List<TravelPriceDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID, Destination, LimitTime, EstDistance"
                    + ", NumberOfSeats, Price from TravelPrice"
                    + " where Destination like N'%" + destination + "%'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("TravelID");
                String des = rs.getString("Destination");
                int limitTime = rs.getInt("LimitTime");
                int estDistance = rs.getInt("EstDistance");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                int price = rs.getInt("Price");
                list.add(new TravelPriceDTO(id, des, limitTime, estDistance, numberOfSeats, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<TravelPriceDTO> findByDestinationAndSeats(String destination, int seats) {
        List<TravelPriceDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID, Destination, LimitTime, EstDistance"
                    + ", NumberOfSeats, Price from TravelPrice"
                    + " where Destination like N'%" + destination + "%' and NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, seats);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("TravelID");
                String des = rs.getString("Destination");
                int limitTime = rs.getInt("LimitTime");
                int estDistance = rs.getInt("EstDistance");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                int price = rs.getInt("Price");
                list.add(new TravelPriceDTO(id, des, limitTime, estDistance, numberOfSeats, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean findExisting(String key) {
        boolean result = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select TravelID from TravelPrice "
                    + "where TravelID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(TravelPriceDTO tpDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into TravelPrice values "
                    + "(?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tpDTO.getId());
            preStm.setString(2, tpDTO.getDestination());
            preStm.setInt(3, tpDTO.getLimitTime());
            preStm.setInt(4, tpDTO.getEstDistance());
            preStm.setInt(5, tpDTO.getNumberOfSeats());
            preStm.setInt(6, tpDTO.getPrice());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
