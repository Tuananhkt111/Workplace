/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.CarDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuana
 */
public class CarDAO implements Serializable {

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

    public CarDTO findByPrimaryKey(String key) {
        CarDTO carDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarName, NumberOfSeats, isAvailable"
                    + " from Car where CarSerial = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                String carName = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                boolean isAvailable = rs.getBoolean("isAvailable");
                carDTO = new CarDTO(key, carName, numberOfSeats, isAvailable);
            }
        } catch (Exception e) {
        } finally {
            //5.Close connection
            closeConnection();
        }
        return carDTO;
    }

    public List<CarDTO> findAll() {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName, NumberOfSeats, isAvailable"
                    + " from Car order by NumberOfSeats ASC, CarName ASC";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            //4.Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                boolean isAvailable = rs.getBoolean("isAvailable");
                list.add(new CarDTO(id, name, numberOfSeats, isAvailable));
            }
        } catch (Exception e) {
        } finally {
            //5.Close connection
            closeConnection();
        }
        return list;
    }

    public List<CarDTO> findAvailableBySeats(int seats, Timestamp startTime, Timestamp endTime) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName"
                    + " from Car where isAvailable = ? and NumberOfSeats = ?"
                    + " except select Car.CarSerial, CarName"
                    + " from Car, TravelTransaction where isAvailable = ? and NumberOfSeats = ? "
                    + "and Car.CarSerial = TravelTransaction.CarSerial"
                    + " and ((StartTime <= ? and ? < EndTime) "
                    + "or (StartTime < ? and ? <= EndTime) "
                    + "or (StartTime >= ? and EndTime <= ?))";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            preStm.setBoolean(3, true);
            preStm.setInt(4, seats);
            preStm.setTimestamp(5, startTime);
            preStm.setTimestamp(6, startTime);
            preStm.setTimestamp(7, endTime);
            preStm.setTimestamp(8, endTime);
            preStm.setTimestamp(9, startTime);
            preStm.setTimestamp(10, endTime);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                list.add(new CarDTO(id, name, seats, true));
            }
        } catch (Exception e) {
        } finally {
            //5.Close connection
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
            String sql = "select CarSerial from Car "
                    + "where CarSerial = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return result;
    }

    public List<CarDTO> findAvailableByCarNameAndSeats(String carName, int seats, Timestamp startTime, Timestamp endTime) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName"
                    + " from Car where isAvailable = ? and "
                    + "CarName like '%" + carName + "%' and NumberOfSeats = ?"
                    + " except select Car.CarSerial, CarName"
                    + " from Car, TravelTransaction where isAvailable = ? and NumberOfSeats = ? "
                    + "and Car.CarSerial = TravelTransaction.CarSerial"
                    + " and ((StartTime <= ? and ? < EndTime) "
                    + "or (StartTime < ? and ? <= EndTime) "
                    + "or (StartTime >= ? and EndTime <= ?))";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            preStm.setBoolean(3, true);
            preStm.setInt(4, seats);
            preStm.setTimestamp(5, startTime);
            preStm.setTimestamp(6, startTime);
            preStm.setTimestamp(7, endTime);
            preStm.setTimestamp(8, endTime);
            preStm.setTimestamp(9, startTime);
            preStm.setTimestamp(10, endTime);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                list.add(new CarDTO(id, name, seats, true));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }

    public boolean delete(String id) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input SQL query
            String sql = "delete from Car where CarSerial = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }

    public boolean insert(CarDTO carDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into Car values "
                    + "(?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, carDTO.getSerial());
            preStm.setString(2, carDTO.getName());
            preStm.setInt(3, carDTO.getNumberOfSeats());
            preStm.setBoolean(4, carDTO.isIsAvailable());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
}
