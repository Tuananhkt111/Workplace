/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactiondetails;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    public ArrayList<TransactionDetailsDTO> loadTransDetailsByTranID(String tranID) throws NamingException, SQLException {
        ArrayList<TransactionDetailsDTO> list = null;
        try {
            String sql = "select BookID, Title, Quantity, Price from TransactionDetails where TranID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tranID);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookID = rs.getString("BookID");
                String title = rs.getString("Title");
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("Price");
                list.add(new TransactionDetailsDTO(tranID, bookID, title, quantity, price));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
