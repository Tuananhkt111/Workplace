/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactions;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<TransactionDTO> loadTransByUserID(String userID) throws NamingException, SQLException {
        ArrayList<TransactionDTO> list = null;
        try {
            String sql = "select TranID, TotalPrice, TimeBought, SalePercent from Transactions where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tranID = rs.getString("TranID");
                float totalPrice = rs.getFloat("TotalPrice");
                Timestamp timeBought = rs.getTimestamp("TimeBought");
                TransactionDTO dto = new TransactionDTO(tranID, userID, totalPrice, timeBought);
                int salePercent = rs.getInt("SalePercent");
                if(salePercent != 0) {
                    dto.setSalePercent(salePercent);
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ArrayList<TransactionDTO> loadTransByUserIDAndName(String userID, String name) throws NamingException, SQLException {
        ArrayList<TransactionDTO> list = null;
        try {
            String sql = "select distinct Transactions.TranID, TotalPrice, TimeBought from Transactions join (select TranID from TransactionDetails where Title Like ?) as TranDetails on TranDetails.TranID = Transactions.TranID and UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            preStm.setString(2, userID);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tranID = rs.getString("TranID");
                float totalPrice = rs.getFloat("TotalPrice");
                Timestamp timeBought = rs.getTimestamp("TimeBought");
                list.add(new TransactionDTO(tranID, userID, totalPrice, timeBought));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ArrayList<TransactionDTO> loadTransByUserIDAndDate(String userID, Date date) throws NamingException, SQLException {
        ArrayList<TransactionDTO> list = null;
        try {
            String sql = "select distinct Transactions.TranID, TotalPrice, TimeBought from Transactions join (select TranID from TransactionDetails) as TranDetails on TranDetails.TranID = Transactions.TranID and UserID = ? and TimeBought >= ? and TimeBought < ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(2, new Timestamp(date.getTime() - 660000));
            preStm.setTimestamp(3, new Timestamp(date.getTime() + 85740000));
            preStm.setString(1, userID);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tranID = rs.getString("TranID");
                float totalPrice = rs.getFloat("TotalPrice");
                Timestamp timeBought = rs.getTimestamp("TimeBought");
                list.add(new TransactionDTO(tranID, userID, totalPrice, timeBought));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
