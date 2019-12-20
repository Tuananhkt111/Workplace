/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactiondetails;

import anhht.bookingcart.BookingDetails;
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
public class TransactionDetailsDAO implements Serializable {
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
    public ArrayList<BookingDetails> loadBookingDetailsByTranID(String tranID) throws SQLException, NamingException {
        ArrayList<BookingDetails> list = null;
        try {
            String sql = "select Count(RoomType) as Quantity, RoomType, HotelName, DateCheckin, DateCheckout, Sum(SubPrice) as Price from TransactionDetails where TranID = ? group by RoomType, HotelName, DateCheckin, DateCheckout";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String hotelName = rs.getString("HotelName");
                String roomType = rs.getString("RoomType");
                int quantity = rs.getInt("Quantity");
                Date dateCheckin = rs.getDate("DateCheckin");
                Date dateCheckout = rs.getDate("DateCheckout");
                float price = rs.getFloat("Price");
                list.add(new BookingDetails(hotelName, roomType, quantity, dateCheckin, dateCheckout, price));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
