/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.daos;

import anht.db.MyConnection;
import anht.dtos.EmployeeDTO;
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
public class EmpDAO implements Serializable{
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
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return empDTO;
    }
    
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select EmpID, EmpName, EmpSex, EmpAge, EmpPhone, EmpCertificate, isAvailable from Employee";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
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
            String sql = "select EmpID from Employee "
                    + "where EmpID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = true;
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
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
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
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
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String id) {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "delete from Employee where EmpID = ?";
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
}
