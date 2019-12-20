/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.daos;

import anht.db.MyConnection;
import anht.dtos.CarDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ex.printStackTrace();
        }
    }

    public CarDTO findByPrimaryKey(String key) {
        CarDTO carDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName, NumberOfSeats, isAvailable"
                    + " from Car where CarSerial = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String carSerial = rs.getString("CarSerial");
                String carName = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                boolean isAvailable = rs.getBoolean("isAvailable");
                carDTO = new CarDTO(carSerial, carName, numberOfSeats, isAvailable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            String sql = "select CarSerial, CarName, NumberOfSeats, isAvailable from Car";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                boolean isAvailable = rs.getBoolean("isAvailable");
                list.add(new CarDTO(id, name, numberOfSeats, isAvailable));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CarDTO> findAvailableBySeats(int seats) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName, NumberOfSeats"
                    + " from Car where isAvailable = ? and NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                list.add(new CarDTO(id, name, numberOfSeats, true));
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
            String sql = "select CarSerial from Car "
                    + "where CarSerial = ?";
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

    public List<CarDTO> findAvailableDistinctBySeats(int seats) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select DISTINCT CarName"
                    + " from Car where isAvailable = ? and NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("CarName");
                list.add(new CarDTO(null, name, seats, true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CarDTO> findAvailableByCarNameAndSeats(String carName, int seats) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CarSerial, CarName, NumberOfSeats"
                    + " from Car where isAvailable = ? and "
                    + "CarName like '%" + carName + "%' and NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CarSerial");
                String name = rs.getString("CarName");
                int numberOfSeats = rs.getInt("NumberOfSeats");
                list.add(new CarDTO(id, name, numberOfSeats, true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CarDTO> findAvailableDistinctByCarNameAndSeats(String carName, int seats) {
        List<CarDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select distinct CarName"
                    + " from Car where isAvailable = ? and "
                    + "CarName like '%" + carName + "%' and NumberOfSeats = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(2, seats);
            preStm.setBoolean(1, true);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("CarName");
                list.add(new CarDTO(null, name, seats, true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean setAvailable(CarDTO carDTO, boolean isAvailable) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update Car set isAvailable = ? where CarSerial = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, isAvailable);
            preStm.setString(2, carDTO.getSerial());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "delete from Car where CarSerial = ?";
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
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
