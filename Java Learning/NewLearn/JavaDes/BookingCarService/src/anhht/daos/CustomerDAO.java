/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.CustomerDTO;
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
        }
    }

    public boolean findExisting(String key) {
        boolean result = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CusID from Customer "
                    + "where CusID = ?";
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

    public boolean insert(CustomerDTO cusDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into Customer values "
                    + "(?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cusDTO.getId());
            preStm.setString(2, cusDTO.getName());
            preStm.setBoolean(3, cusDTO.isSex());
            preStm.setInt(4, cusDTO.getAge());
            preStm.setString(5, cusDTO.getPhone());
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
            String sql = "delete from Customer where CusID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(CustomerDTO cusDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update Customer set "
                    + "CusName = ?, CusSex = ?, CusAge = ?,"
                    + " CusPhone = ? where CusID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cusDTO.getName());
            preStm.setBoolean(2, cusDTO.isSex());
            preStm.setInt(3, cusDTO.getAge());
            preStm.setString(4, cusDTO.getPhone());
            preStm.setString(5, cusDTO.getId());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }

    public CustomerDTO findByPrimaryKey(String key) {
        CustomerDTO cusDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CusName, CusSex, CusAge, CusPhone from Customer "
                    + "where CusID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                String name = rs.getString("CusName");
                boolean sex = rs.getBoolean("CusSex");
                int age = rs.getInt("CusAge");
                String phone = rs.getString("CusPhone");
                cusDTO = new CustomerDTO(key, name, phone, sex, age);
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return cusDTO;
    }

    public List<CustomerDTO> findAll() {
        List<CustomerDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select CusID, CusName, CusSex, CusAge, CusPhone"
                    + " from Customer order by CusName ASC";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CusID");
                String name = rs.getString("CusName");
                boolean sex = rs.getBoolean("CusSex");
                int age = rs.getInt("CusAge");
                String phone = rs.getString("CusPhone");
                list.add(new CustomerDTO(id, name, phone, sex, age));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
}
