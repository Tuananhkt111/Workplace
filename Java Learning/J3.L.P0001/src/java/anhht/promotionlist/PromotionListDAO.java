/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.promotionlist;

import anhht.prolistdetails.ProListDetailsDTO;
import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class PromotionListDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public HashMap<String, ProListDetailsDTO> loadProList() throws SQLException, NamingException {
        HashMap<String, ProListDetailsDTO> list = null;
        try {
            String sql = "select UserID, Rank from PromotionList where TimeAssigned = (Select Max(TimeAssigned) from PromotionList)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new HashMap<>();
            while (rs.next()) {
                String userID = rs.getString("UserID");
                float mark = rs.getFloat("rank");
                list.put(userID, new ProListDetailsDTO(userID, mark));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public HashMap<String, ProListDetailsDTO> loadProListByUserID(String id) throws SQLException, NamingException {
        HashMap<String, ProListDetailsDTO> list = null;
        try {
            String sql = "select PlID, Rank, TimeAssigned from PromotionList where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            list = new HashMap<>();
            while (rs.next()) {
                String plID = rs.getString("PlID");
                float rank = rs.getFloat("rank");
                Timestamp timeAssigned = rs.getTimestamp("TimeAssigned");
                list.put(plID, new ProListDetailsDTO(id, plID, rank, timeAssigned));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public void saveProList(PromotionListDTO dto) throws SQLException, NamingException {
        try {
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into PromotionList (PlID, UserID, Rank, TimeAssigned) values(?, ?, ?, ?)";
            Date date = new Date();
            Timestamp timeAssigned = new Timestamp(date.getTime());
            long plID = date.getTime();
            for (ProListDetailsDTO pldDTO : dto.getList().values()) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, Long.toString(plID++));
                preStm.setString(2, pldDTO.getUserID());
                preStm.setFloat(3, pldDTO.getRank());
                preStm.setTimestamp(4, timeAssigned);
                preStm.executeUpdate();
            }
            conn.commit();
        } finally {
            closeConnection();
        }
    }
}
