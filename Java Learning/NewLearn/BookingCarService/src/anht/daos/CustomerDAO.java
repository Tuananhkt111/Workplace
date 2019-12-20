/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.daos;

import anht.db.MyConnection;
import anht.dtos.CustomerDTO;
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
public class CustomerDAO implements Serializable {

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
    public boolean findExisting(String key) {
        boolean result = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select AccID from Customer "
                    + "where AccID = ?";
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

    public boolean insert(CustomerDTO accDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into Customer values "
                    + "(?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, accDTO.getId());
            preStm.setString(2, accDTO.getPassword());
            preStm.setString(3, accDTO.getRole());
            preStm.setString(4, accDTO.getName());
            preStm.setBoolean(5, accDTO.isSex());
            preStm.setInt(6, accDTO.getAge());
            preStm.setString(7, accDTO.getPhone());
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
            String sql = "delete from Customer where AccID = ?";
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

    public boolean update(CustomerDTO accDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update Customer set AccPass = ?, AccRole = ?, "
                    + "AccName = ?, AccSex = ?, AccAge = ?,"
                    + " AccPhone = ? where AccID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, accDTO.getPassword());
            preStm.setString(2, accDTO.getRole());
            preStm.setString(3, accDTO.getName());
            preStm.setBoolean(4, accDTO.isSex());
            preStm.setInt(5, accDTO.getAge());
            preStm.setString(6, accDTO.getPhone());
            preStm.setString(7, accDTO.getId());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public CustomerDTO findByPrimaryKey(String key) {
        CustomerDTO accDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select AccID, AccPass, AccName, AccSex, AccAge, AccPhone from Customer "
                    + "where AccID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("AccID");
                String pass = rs.getString("AccPass");
                String name = rs.getString("AccName");
                boolean sex = rs.getBoolean("AccSex");
                int age = rs.getInt("AccAge");
                String phone = rs.getString("AccPhone");
                accDTO = new CustomerDTO(id, pass, name, phone, sex, age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return accDTO;
    }

    public List<CustomerDTO> findAllUsers() {
        List<CustomerDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select AccID, AccPass, AccName, AccSex, AccAge, AccPhone from Customer where AccRole = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Customer");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("AccID");
                String pass = rs.getString("AccPass");
                String name = rs.getString("AccName");
                boolean sex = rs.getBoolean("AccSex");
                int age = rs.getInt("AccAge");
                String phone = rs.getString("AccPhone");
                list.add(new CustomerDTO(id, pass, name, phone, sex, age));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
}
