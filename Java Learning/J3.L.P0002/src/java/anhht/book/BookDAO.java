/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.book;

import anhht.shoppingcart.ShoppingCart;
import anhht.transactiondetails.TransactionDetailsDTO;
import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class BookDAO implements Serializable {

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

    public boolean insert(BookDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "insert into Book (BookID, Title, CatID, Author, Description, Image, Price, ImportDate, Quantity, Status) values(?,?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBookID());
            preStm.setString(2, dto.getTitle());
            preStm.setString(3, dto.getCatID());
            preStm.setString(4, dto.getAuthor());
            preStm.setString(5, dto.getDescription());
            preStm.setString(6, dto.getImage());
            preStm.setFloat(7, dto.getPrice());
            preStm.setDate(8, new java.sql.Date(dto.getImportDate().getTime()));
            preStm.setInt(9, dto.getQuantity());
            preStm.setString(10, dto.getStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(BookDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Book set Title = ?, CatID = ?, Author = ?, Description = ?, Image = ?, Price = ?, ImportDate = ?, Quantity = ?, Status = ? where BookID = ?";
            String sql2 = "update Book set Title = ?, CatID = ?, Author = ?, Description = ?, Price = ?, ImportDate = ?, Quantity = ?, Status = ? where BookID = ?";
            conn = MyConnection.getMyConnection();
            if (dto.getImage().equals("")) {
                preStm = conn.prepareStatement(sql2);
                preStm.setFloat(5, dto.getPrice());
                preStm.setDate(6, new java.sql.Date(dto.getImportDate().getTime()));
                preStm.setInt(7, dto.getQuantity());
                preStm.setString(8, dto.getStatus());
                preStm.setString(9, dto.getBookID());
            } else {
                preStm = conn.prepareStatement(sql);
                preStm.setString(10, dto.getBookID());
                preStm.setString(5, dto.getImage());
                preStm.setFloat(6, dto.getPrice());
                preStm.setDate(7, new java.sql.Date(dto.getImportDate().getTime()));
                preStm.setInt(8, dto.getQuantity());
                preStm.setString(9, dto.getStatus());
            }
            preStm.setString(1, dto.getTitle());
            preStm.setString(2, dto.getCatID());
            preStm.setString(3, dto.getAuthor());
            preStm.setString(4, dto.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String bookID) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Book set Status = ? where BookID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(2, bookID);
            preStm.setString(1, "Inactive");
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ArrayList<BookDTO> searchBookByName(String name) throws NamingException, SQLException {
        ArrayList<BookDTO> list = null;
        try {
            String sql = "select BookID, Title, Book.CatID, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Title LIKE ? and Status = ? and Quantity > ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            preStm.setString(2, "Active");
            preStm.setInt(3, 0);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookID = rs.getString("BookID");
                String title = rs.getString("Title");
                String catID = rs.getString("CatID");
                String catName = rs.getString("CatName");
                String author = rs.getString("Author");
                String des = rs.getString("Description");
                String image = rs.getString("Image");
                float price = rs.getFloat("Price");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                list.add(new BookDTO(bookID, title, catID, author, des, image, "Active", catName, price, quantity, importDate));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<BookDTO> searchBookByPrice(float min, float max) throws NamingException, SQLException {
        ArrayList<BookDTO> list = null;
        try {
            String sqlMin = "select BookID, Title, Book.CatID, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Price <= ? and Status = ? and Quantity > ?";
            String sqlMax = "select BookID, Title, Book.CatID, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Price >= ? and Status = ? and Quantity > ?";
            String sqlMinMax = "select BookID, Title, Book.CatID, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Status = ? and Quantity > ?";
            String sql = "select BookID, Title, Book.CatID, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Price >= ? and Price <= ? and Status = ? and Quantity > ?";
            conn = MyConnection.getMyConnection();
            if (min == 0) {
                if (max == 0) {
                    preStm = conn.prepareStatement(sqlMinMax);
                    preStm.setString(1, "Active");
                    preStm.setInt(2, 0);
                } else {
                    preStm = conn.prepareStatement(sqlMin);
                    preStm.setFloat(1, max);
                    preStm.setString(2, "Active");
                    preStm.setInt(3, 0);
                }
            } else {
                if (max == 0) {
                    preStm = conn.prepareStatement(sqlMax);
                    preStm.setFloat(1, min);
                    preStm.setString(2, "Active");
                    preStm.setInt(3, 0);
                } else {
                    preStm = conn.prepareStatement(sql);
                    preStm.setFloat(1, min);
                    preStm.setFloat(2, max);
                    preStm.setString(3, "Active");
                    preStm.setInt(4, 0);
                }
            }
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookID = rs.getString("BookID");
                String title = rs.getString("Title");
                String catID = rs.getString("CatID");
                String catName = rs.getString("CatName");
                String author = rs.getString("Author");
                String des = rs.getString("Description");
                String image = rs.getString("Image");
                float price = rs.getFloat("Price");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                list.add(new BookDTO(bookID, title, catID, author, des, image, "Active", catName, price, quantity, importDate));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<BookDTO> searchBookByCategory(String catID) throws NamingException, SQLException {
        ArrayList<BookDTO> list = null;
        try {
            String sql = "select BookID, Title, CatName, Author, Description, Image, Price, ImportDate, Quantity from Book join Category on Book.CatID = Category.CatID and Book.CatID = ? and Status = ? and Quantity > ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, catID);
            preStm.setString(2, "Active");
            preStm.setInt(3, 0);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookID = rs.getString("BookID");
                String title = rs.getString("Title");
                String catName = rs.getString("CatName");
                String author = rs.getString("Author");
                String des = rs.getString("Description");
                String image = rs.getString("Image");
                float price = rs.getFloat("Price");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                list.add(new BookDTO(bookID, title, catID, author, des, image, "Active", catName, price, quantity, importDate));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public BookDTO searchBookByBookID(String bookID) throws NamingException, SQLException {
        BookDTO dto = null;
        try {
            String sql = "select CatID, Title, Author, Description, Image, Price, ImportDate, Quantity from Book where BookID = ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, bookID);
            preStm.setString(2, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                String catID = rs.getString("CatID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                String des = rs.getString("Description");
                String image = rs.getString("Image");
                float price = rs.getFloat("Price");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                dto = new BookDTO(bookID, title, catID, author, des, image, "Active", price, quantity, importDate);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public int searchQuantityByBookID(String bookID) throws NamingException, SQLException {
        int result = -1;
        try {
            String sql = "select Quantity from Book where BookID = ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, bookID);
            preStm.setString(2, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("Quantity");
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkout(ShoppingCart dto, String userID, float total) throws NamingException, SQLException {
        boolean check = false;
        try {
            Date date = new Date();
            Timestamp timeBought = new Timestamp(date.getTime());
            String tranID = "TRAN" + UUID.randomUUID().toString();
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into Transactions (TranID, UserID, TotalPrice, TimeBought) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            preStm.setString(2, userID);
            preStm.setFloat(3, total);
            preStm.setTimestamp(4, timeBought);
            preStm.executeUpdate();
            String sql2 = "Insert into TransactionDetails (TranID, BookID, Title, Quantity, Price, TotalPrice) values (?,?,?,?,?,?)";
            for (TransactionDetailsDTO tdDTO : dto.getCart().values()) {
                preStm = conn.prepareStatement(sql2);
                preStm.setString(1, tranID);
                preStm.setString(2, tdDTO.getBookID());
                preStm.setString(3, tdDTO.getTitle());
                preStm.setInt(4, tdDTO.getQuantity());
                preStm.setFloat(5, tdDTO.getPrice());
                preStm.setFloat(6, tdDTO.getTotalPrice());
                preStm.executeUpdate();
            }
            String sql3 = "update Book set Quantity = ? where BookID = ?";
            for (TransactionDetailsDTO tdDTO : dto.getCart().values()) {
                preStm = conn.prepareStatement(sql3);
                preStm.setFloat(1, tdDTO.getAvailableQuantity() - tdDTO.getQuantity());
                preStm.setString(2, tdDTO.getBookID());
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

    public boolean checkout(ShoppingCart dto, String userID, float total, int salePercent, String code) throws NamingException, SQLException {
        boolean check = false;
        try {
            Date date = new Date();
            Timestamp timeBought = new Timestamp(date.getTime());
            String tranID = "TRAN" + UUID.randomUUID().toString();
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into Transactions (TranID, UserID, TotalPrice, TimeBought, SalePercent) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            preStm.setString(2, userID);
            preStm.setFloat(3, total);
            preStm.setTimestamp(4, timeBought);
            preStm.setInt(5, salePercent);
            preStm.executeUpdate();
            String sql2 = "Insert into TransactionDetails (TranID, BookID, Title, Quantity, Price, TotalPrice) values (?,?,?,?,?,?)";
            for (TransactionDetailsDTO tdDTO : dto.getCart().values()) {
                preStm = conn.prepareStatement(sql2);
                preStm.setString(1, tranID);
                preStm.setString(2, tdDTO.getBookID());
                preStm.setString(3, tdDTO.getTitle());
                preStm.setInt(4, tdDTO.getQuantity());
                preStm.setFloat(5, tdDTO.getPrice());
                preStm.setFloat(6, tdDTO.getTotalPrice());
                preStm.executeUpdate();
            }
            String sql3 = "update Book set Quantity = ? where BookID = ?";
            for (TransactionDetailsDTO tdDTO : dto.getCart().values()) {
                preStm = conn.prepareStatement(sql3);
                preStm.setFloat(1, tdDTO.getAvailableQuantity() - tdDTO.getQuantity());
                preStm.setString(2, tdDTO.getBookID());
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
}
