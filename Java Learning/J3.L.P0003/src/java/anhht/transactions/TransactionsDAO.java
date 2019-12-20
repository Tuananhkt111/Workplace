/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactions;

import anhht.bookingcart.BookingCart;
import anhht.bookingcart.BookingDetails;
import anhht.discount.DiscountDAO;
import anhht.room.RoomDTO;
import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class TransactionsDAO implements Serializable {

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

    public boolean checkout(BookingCart cart, String email, float total, ArrayList<RoomDTO> bookList) throws NamingException, SQLException {
        boolean check = false;
        try {
            String tranID = "TRAN" + UUID.randomUUID().toString();
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into Transactions (TranID, Email, TotalPrice, DateBooked, Status) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            preStm.setString(2, email);
            preStm.setFloat(3, total);
            preStm.setDate(4, new java.sql.Date(new Date().getTime()));
            preStm.setString(5, "Active");
            preStm.executeUpdate();
            String sql2 = "Insert into TransactionDetails (TranID, RoomID, HotelName, RoomType, DateCheckin, DateCheckout, SubPrice) values (?,?,?,?,?,?,?)";
            for (RoomDTO roomDTO : bookList) {
                BookingDetails bd = cart.getCart().get(roomDTO.getRoomTypeID());
                preStm = conn.prepareStatement(sql2);
                preStm.setString(1, tranID);
                preStm.setString(2, roomDTO.getRoomID());
                preStm.setString(3, bd.getHotelName());
                preStm.setString(4, bd.getRoomType());
                preStm.setDate(5, new java.sql.Date(bd.getDateCheckin().getTime()));
                preStm.setDate(6, new java.sql.Date(bd.getDateCheckout().getTime()));
                preStm.setFloat(7, bd.getPrice()*((bd.getDateCheckout().getTime() - bd.getDateCheckin().getTime())/86400000));
                preStm.executeUpdate();
            }
            conn.commit();
            check = true;
        } catch (SQLException se) {
            conn.rollback();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkout(BookingCart cart, String email, float total, String code, ArrayList<RoomDTO> bookList) throws NamingException, SQLException {
        boolean check = false;
        try {
            String tranID = "TRAN" + UUID.randomUUID().toString();
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into Transactions (TranID, Email, DiscountCode, TotalPrice, DateBooked, Status) values(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            preStm.setString(2, email);
            preStm.setString(3, code);
            preStm.setFloat(4, total);
            preStm.setDate(5, new java.sql.Date(new Date().getTime()));
            preStm.setString(6, "Active");
            preStm.executeUpdate();
            String sql2 = "Insert into TransactionDetails (TranID, RoomID, HotelName, RoomType, DateCheckin, DateCheckout, SubPrice) values (?,?,?,?,?,?,?)";
            for (RoomDTO roomDTO : bookList) {
                BookingDetails bd = cart.getCart().get(roomDTO.getRoomTypeID());
                preStm = conn.prepareStatement(sql2);
                preStm.setString(1, tranID);
                preStm.setString(2, roomDTO.getRoomID());
                preStm.setString(3, bd.getHotelName());
                preStm.setString(4, bd.getRoomType());
                preStm.setDate(5, new java.sql.Date(bd.getDateCheckin().getTime()));
                preStm.setDate(6, new java.sql.Date(bd.getDateCheckout().getTime()));
                preStm.setFloat(7, bd.getPrice()*((bd.getDateCheckout().getTime() - bd.getDateCheckin().getTime())/86400000));
                preStm.executeUpdate();
            }
            String sql4 = "update Discount set Status = ? where DiscountCode = ?";
            preStm = conn.prepareStatement(sql4);
            preStm.setString(1, "Invalid");
            preStm.setString(2, code);
            preStm.executeUpdate();
            conn.commit();
            check = true;
        } catch (SQLException se) {
            conn.rollback();
        } finally {
            closeConnection();
        }
        return check;
    }
    public ArrayList<TransactionsDTO> loadTransByEmail(String email) throws NamingException, SQLException {
        ArrayList<TransactionsDTO> list = null;
        try {
            String sql = "select TranID, TotalPrice, DateBooked, DiscountCode from Transactions where Email = ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            preStm.setString(2, "Active");
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tranID = rs.getString("TranID");
                float totalPrice = rs.getFloat("TotalPrice");
                Date dateBooked = rs.getDate("DateBooked");
                String discountCode = rs.getString("DiscountCode");
                TransactionsDTO dto = new TransactionsDTO(tranID, email, "", totalPrice, 0, dateBooked);
                if(discountCode != null) {
                    DiscountDAO dao = new DiscountDAO();
                    int salePercent = dao.loadSalePercentByCode(discountCode);
                    dto.setDiscountCode(discountCode);
                    dto.setSalePercent(salePercent);
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
       
    public ArrayList<TransactionsDTO> loadTransByEmailAndDate(String email, Date date) throws NamingException, SQLException {
        ArrayList<TransactionsDTO> list = null;
        try {
            String sql = "select TranID, TotalPrice, DateBooked, DiscountCode from Transactions where Email = ? and Status = ? and DateBooked = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setDate(3, new java.sql.Date(date.getTime()));
            preStm.setString(1, email);
            preStm.setString(2, "Active");
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tranID = rs.getString("TranID");
                float totalPrice = rs.getFloat("TotalPrice");
                Date dateBooked = rs.getDate("DateBooked");
                String discountCode = rs.getString("DiscountCode");
                TransactionsDTO dto = new TransactionsDTO(tranID, email, "", totalPrice, 0, dateBooked);
                if(discountCode != null) {
                    DiscountDAO dao = new DiscountDAO();
                    int salePercent = dao.loadSalePercentByCode(discountCode);
                    dto.setDiscountCode(discountCode);
                    dto.setSalePercent(salePercent);
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public boolean deleteTran(String tranID) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Transactions set Status = ? where TranID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(2, tranID);
            preStm.setString(1, "Inactive");
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
