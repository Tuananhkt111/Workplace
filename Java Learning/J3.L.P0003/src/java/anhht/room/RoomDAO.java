/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.room;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class RoomDAO implements Serializable {

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

    public ArrayList<RoomDTO> loadRoomByRoomTypeID(String roomTypeID, Date dateCheckin, Date dateCheckout, int quantity) throws SQLException, NamingException {
        ArrayList<RoomDTO> list = null;
        try {
            String sql = "select top (?) RoomID from Room "
                    + "where Status = ? and RoomTypeID = ? "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quantity);
            preStm.setString(2, "Active");
            preStm.setString(3, roomTypeID);
            preStm.setDate(4, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(5, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(7, new java.sql.Date(dateCheckout.getTime()));
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String roomID = rs.getString("RoomID");
                list.add(new RoomDTO(roomID, roomTypeID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
