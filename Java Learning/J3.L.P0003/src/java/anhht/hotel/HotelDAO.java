/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.hotel;

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
public class HotelDAO implements Serializable {

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

    public ArrayList<HotelDTO> searchHotelByArea(String areaName, Date dateCheckin, Date dateCheckout, int quantity) throws SQLException, NamingException {
        ArrayList<HotelDTO> list = null;
        try {
            String sql = "select Hotel.HotelID, HotelName, Address, Phone, Photo, Description, MinPrice from Hotel join (select HotelID, Min(Price) as MinPrice from RoomType where RoomTypeID in (select RoomTypeID from Room "
                    + "where Status = ? and RoomTypeID in (select RoomTypeID from RoomType "
                    + "where Status = ? and HotelID in (select Hotel.HotelID from Hotel "
                    + "where Status = ? and Hotel.AreaID in (select AreaID from Area "
                    + "where AreaName like ?))) "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))"
                    + " group by RoomTypeID"
                    + " having COUNT(RoomTypeID) >= ?) group by HotelID) as RoomTypeAvalable on Hotel.HotelID = RoomTypeAvalable.HotelID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Active");
            preStm.setString(2, "Active");
            preStm.setString(3, "Active");
            preStm.setString(4, "%" + areaName + "%");
            preStm.setDate(5, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(7, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(8, new java.sql.Date(dateCheckout.getTime()));
            preStm.setInt(9, quantity);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String hotelID = rs.getString("HotelID");
                String hotelName = rs.getString("HotelName");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String photo = rs.getString("Photo");
                String description = rs.getString("Description");
                float minPrice = rs.getFloat("MinPrice");
                list.add(new HotelDTO(hotelID, hotelName, address, phone, photo, description, minPrice));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ArrayList<HotelDTO> searchHotelByName(String name, Date dateCheckin, Date dateCheckout, int quantity) throws SQLException, NamingException {
        ArrayList<HotelDTO> list = null;
        try {
            String sql = "select Hotel.HotelID, HotelName, Address, Phone, Photo, Description, MinPrice from Hotel join (select HotelID, Min(Price) as MinPrice from RoomType where RoomTypeID in (select RoomTypeID from Room "
                    + "where Status = ? and RoomTypeID in (select RoomTypeID from RoomType "
                    + "where Status = ? and HotelID in (select Hotel.HotelID from Hotel "
                    + "where Status = ? and HotelName LIKE ?)) "
                    + "and RoomID not in (select RoomID from TransactionDetails "
                    + "where ((? between DateCheckin AND DateCheckout)"
                    + " or (? between DateCheckin AND DateCheckout)"
                    + " or (DateCheckin > ? and DateCheckout < ?)))"
                    + " group by RoomTypeID"
                    + " having COUNT(RoomTypeID) >= ?) group by HotelID) as RoomTypeAvalable on Hotel.HotelID = RoomTypeAvalable.HotelID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Active");
            preStm.setString(2, "Active");
            preStm.setString(3, "Active");
            preStm.setString(4, "%" + name + "%");
            preStm.setDate(5, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(6, new java.sql.Date(dateCheckout.getTime()));
            preStm.setDate(7, new java.sql.Date(dateCheckin.getTime()));
            preStm.setDate(8, new java.sql.Date(dateCheckout.getTime()));
            preStm.setInt(9, quantity);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String hotelID = rs.getString("HotelID");
                String hotelName = rs.getString("HotelName");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String photo = rs.getString("Photo");
                String description = rs.getString("Description");
                float minPrice = rs.getFloat("MinPrice");
                list.add(new HotelDTO(hotelID, hotelName, address, phone, photo, description, minPrice));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
