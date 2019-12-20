/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.roomtype;

import anhht.hotel.HotelDTO;
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
public class RoomTypeDAO implements Serializable {
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

    public ArrayList<RoomTypeDTO> searchRoomTypeByHotelID(String hotelID, Date dateCheckin, Date dateCheckout, int quantity) throws SQLException, NamingException {
        ArrayList<RoomTypeDTO> list = null;
        try {
            String sql = "select RoomType.RoomTypeID, RoomType, MaxPeople, Price, Description, AvailableRoom from RoomType join (select RoomTypeID, COUNT(RoomTypeID) as AvailableRoom from Room "
                    + "where Status = ? and RoomTypeID in (select RoomTypeID from RoomType "
                    + "where Status = ? and HotelID = ?) "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))"
                    + " group by RoomTypeID"
                    + " having COUNT(RoomTypeID) >= ?) as RoomAvailable on RoomAvailable.RoomTypeID = RoomType.RoomTypeID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Active");
            preStm.setString(2, "Active");
            preStm.setString(3, hotelID);
            preStm.setDate(4, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(5, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(7, new java.sql.Date(dateCheckout.getTime()));
            preStm.setInt(8, quantity);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String roomTypeID = rs.getString("RoomTypeID");
                String roomType = rs.getString("RoomType");
                int maxPeople = rs.getInt("MaxPeople");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int availableRoom = rs.getInt("AvailableRoom");
                list.add(new RoomTypeDTO(roomTypeID, roomType, description, maxPeople, availableRoom, price));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public RoomTypeDTO loadRoomTypeByID(String roomTypeID, Date dateCheckin, Date dateCheckout, int quantity) throws SQLException, NamingException {
        RoomTypeDTO dto = null;
        try {
            String sql = "select RoomType.RoomTypeID, RoomType, MaxPeople, Price, Description, AvailableRoom from RoomType join (select RoomTypeID, COUNT(RoomTypeID) as AvailableRoom from Room "
                    + "where Status = ? and RoomTypeID = ? "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))"
                    + " group by RoomTypeID"
                    + " having COUNT(RoomTypeID) >= ?) as RoomAvailable on RoomAvailable.RoomTypeID = RoomType.RoomTypeID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Active");
            preStm.setString(2, roomTypeID);
            preStm.setDate(3, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(4, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(5, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckout.getTime()));
            preStm.setInt(7, quantity);
            rs = preStm.executeQuery();
            if(rs.next()) {
                String roomType = rs.getString("RoomType");
                int maxPeople = rs.getInt("MaxPeople");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int availableRoom = rs.getInt("AvailableRoom");
                dto = new RoomTypeDTO(roomTypeID, roomType, description, maxPeople, availableRoom, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public int loadAvailableRoomByRoomTypeID(String roomTypeID, Date dateCheckin, Date dateCheckout) throws SQLException, NamingException {
        int result = -1;
        try {
            String sql = "select AvailableRoom from RoomType join (select RoomTypeID, COUNT(RoomTypeID) as AvailableRoom from Room "
                    + "where Status = ? and RoomTypeID = ? "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))"
                    + " group by RoomTypeID"
                    + ") as RoomAvailable on RoomAvailable.RoomTypeID = RoomType.RoomTypeID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Active");
            preStm.setString(2, roomTypeID);
            preStm.setDate(3, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(4, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(5, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckout.getTime()));
            rs = preStm.executeQuery();
            if(rs.next()) {
                result = rs.getInt("AvailableRoom");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
