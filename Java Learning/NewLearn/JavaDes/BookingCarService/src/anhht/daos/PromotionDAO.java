/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.PromotionDTO;
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
public class PromotionDAO implements Serializable{
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
    
    public boolean findExisting(String key) {
        boolean result = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionCode from Promotion "
                    + "where PromotionCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            //4. Handle result
            rs = preStm.executeQuery();
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
    
    public boolean insert(PromotionDTO pDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "insert into Promotion values "
                    + "(?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pDTO.getCode());
            preStm.setFloat(2, pDTO.getDiscount());
            preStm.setTimestamp(3, pDTO.getStartTime());
            preStm.setTimestamp(4, pDTO.getEndTime());
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
    
    public PromotionDTO findByPrimaryKey(String key) {
        PromotionDTO pDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionDiscount, StartTime, EndTime"
                    + " from Promotion where PromotionCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp startTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                pDTO = new PromotionDTO(key, discount, startTime, endTime);
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return pDTO;
    }
    public boolean update(PromotionDTO pDTO) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "update Promotion set PromotionDiscount = ?,"
                    + " StartTime = ?, EndTime = ? where PromotionCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setFloat(1, pDTO.getDiscount());
            preStm.setTimestamp(2, pDTO.getStartTime());
            preStm.setTimestamp(3, pDTO.getEndTime());
            preStm.setString(4, pDTO.getCode());   
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String code) {
        boolean check = false;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "delete from Promotion where PromotionCode = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            //4. Handle result
            check = preStm.executeUpdate() > 0;
        }  catch (Exception e) {
        }finally {
            //5. Close connection
            closeConnection();
        }
        return check;
    }
    
    public List<PromotionDTO> findAll() {
        List<PromotionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionCode, PromotionDiscount, StartTime, "
                    + "EndTime from Promotion "
                    + "order by StartTime ASC";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("PromotionCode");
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                list.add(new PromotionDTO(code, discount, StartTime, endTime));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
    
    public List<PromotionDTO> findAllByValid(Timestamp currentTime) {
        List<PromotionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionCode, PromotionDiscount, StartTime, "
                    + "EndTime from Promotion where StartTime <= ? and EndTime >= ? "
                    + "order by StartTime ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, currentTime);
            preStm.setTimestamp(2, currentTime);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("PromotionCode");
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                list.add(new PromotionDTO(code, discount, StartTime, endTime));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
    
    public List<PromotionDTO> findAllByInValid(Timestamp currentTime) {
        List<PromotionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionCode, PromotionDiscount, StartTime, "
                    + "EndTime from Promotion where EndTime < ? "
                    + "order by StartTime ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, currentTime);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("PromotionCode");
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                list.add(new PromotionDTO(code, discount, StartTime, endTime));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
    
    public List<PromotionDTO> findAllByInQueue(Timestamp currentTime) {
        List<PromotionDTO> list = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionCode, PromotionDiscount, StartTime, "
                    + "EndTime from Promotion where StartTime > ? "
                    + "order by StartTime ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, currentTime);
            rs = preStm.executeQuery();
            //4. Handle result
            list = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("PromotionCode");
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp StartTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                list.add(new PromotionDTO(code, discount, StartTime, endTime));
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return list;
    }
    
    public PromotionDTO findByPrimaryKeyValid(String key, Timestamp currentTime) {
        PromotionDTO pDTO = null;
        try {
            //1. + //2.
            conn = MyConnection.getMyConnection();
            //3. Input sql query
            String sql = "select PromotionDiscount, StartTime, EndTime"
                    + " from Promotion where PromotionCode = ?"
                    + " and StartTime <= ? and EndTime >= ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            preStm.setTimestamp(2, currentTime);
            preStm.setTimestamp(3, currentTime);
            rs = preStm.executeQuery();
            //4. Handle result
            if (rs.next()) {
                float discount = rs.getFloat("PromotionDiscount");
                Timestamp startTime = rs.getTimestamp("StartTime");
                Timestamp endTime = rs.getTimestamp("EndTime");
                pDTO = new PromotionDTO(key, discount, startTime, endTime);
            }
        } catch (Exception e) {
        } finally {
            //5. Close connection
            closeConnection();
        }
        return pDTO;
    }
}
