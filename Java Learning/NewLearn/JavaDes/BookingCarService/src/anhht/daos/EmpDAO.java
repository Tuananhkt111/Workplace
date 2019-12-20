/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.EmployeeDTO;
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
public class EmpDAO implements Serializable {

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

    public EmployeeDTO findByPrimaryKey(String key) {
        EmployeeDTO empDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate, isAvailable"
                    + " from Employee where EmpID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                String empName = rs.getString("EmpName");
                boolean empSex = rs.getBoolean("EmpSex");
                int empAge = rs.getInt("EmpAge");
                int empCertificate = rs.getInt("EmpCertificate");
                String empPhone = rs.getString("EmpPhone");
                boolean isAvailable = rs.getBoolean("isAvailable");
                empDTO = new EmployeeDTO(key, empName, empPhone, empSex, isAvailable, empAge, empCertificate);
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return empDTO;
    }

    public List<EmployeeDTO> findAvailableByEmpNameAndSeats(String empName, int seats, Timestamp startTime, Timestamp endTime) {
        List<EmployeeDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select EmpID, EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate"
                    + " from Employee where isAvailable = ? and "
                    + "EmpName like '%" + empName + "%' and EmpCertificate >= ?"
                    + " except select Employee.EmpID, EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate"
                    + " from Employee, TravelTransaction where isAvailable = ? and EmpCertificate >= ? "
                    + "and Employee.EmpID = TravelTransaction.EmpID"
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
                String id = rs.getString("EmpID");
                String name = rs.getString("EmpName");
                boolean empSex = rs.getBoolean("EmpSex");
                int empAge = rs.getInt("EmpAge");
                int empCertificate = rs.getInt("EmpCertificate");
                String empPhone = rs.getString("EmpPhone");
                list.add(new EmployeeDTO(id, name, empPhone, empSex, true, empAge, empCertificate));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }

    public List<EmployeeDTO> findAvailableBySeats(int seats, Timestamp startTime, Timestamp endTime) {
        List<EmployeeDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select EmpID, EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate"
                    + " from Employee where isAvailable = ? and EmpCertificate >= ?"
                    + " except select Employee.EmpID, EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate"
                    + " from Employee, TravelTransaction where isAvailable = ? and EmpCertificate >= ? "
                    + "and Employee.EmpID = TravelTransaction.EmpID"
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
                String id = rs.getString("EmpID");
                String name = rs.getString("EmpName");
                boolean empSex = rs.getBoolean("EmpSex");
                int empAge = rs.getInt("EmpAge");
                int empCertificate = rs.getInt("EmpCertificate");
                String empPhone = rs.getString("EmpPhone");
                list.add(new EmployeeDTO(id, name, empPhone, empSex, true, empAge, empCertificate));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }

    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select EmpID, EmpName, EmpSex, EmpAge, EmpPhone, "
                    + "EmpCertificate, isAvailable from Employee order by EmpName ASC";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("EmpID");
                String name = rs.getString("EmpName");
                boolean sex = rs.getBoolean("EmpSex");
                int age = rs.getInt("EmpAge");
                String phone = rs.getString("EmpPhone");
                boolean isAvailable = rs.getBoolean("isAvailable");
                int empCertificate = rs.getInt("EmpCertificate");
                list.add(new EmployeeDTO(id, name, phone, sex, isAvailable, age, empCertificate));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
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
            String sql = "select EmpID from Employee "
                    + "where EmpID = ?";
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

    public boolean insert(EmployeeDTO empDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into Employee values "
                    + "(?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, empDTO.getId());
            preStm.setString(2, empDTO.getName());
            preStm.setBoolean(3, empDTO.isSex());
            preStm.setInt(4, empDTO.getAge());
            preStm.setString(5, empDTO.getPhone());
            preStm.setInt(6, empDTO.getCertificate());
            preStm.setBoolean(7, empDTO.isIsAvailable());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }

    public boolean update(EmployeeDTO empDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update Employee set EmpName = ?, "
                    + "EmpSex = ?, EmpAge = ?, EmpPhone = ?, EmpCertificate = ?,"
                    + " isAvailable = ? where EmpID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, empDTO.getName());
            preStm.setBoolean(6, empDTO.isIsAvailable());
            preStm.setBoolean(2, empDTO.isSex());
            preStm.setInt(3, empDTO.getAge());
            preStm.setInt(5, empDTO.getCertificate());
            preStm.setString(4, empDTO.getPhone());
            preStm.setString(7, empDTO.getId());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input SQL query
            String sql = "delete from Employee where EmpID = ?";
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
}
