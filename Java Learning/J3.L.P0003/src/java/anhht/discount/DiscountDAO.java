/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.discount;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class DiscountDAO implements Serializable {
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
    public DiscountDTO loadCode(String code) throws SQLException, NamingException {
        DiscountDTO dto = null;
        try {
            String sql = "select SalePercent, Status, DateBegin, DateEnd from Discount where DiscountCode = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            if(rs.next()) {
                int salePercent = rs.getInt("SalePercent");
                String status = rs.getString("Status");
                Date dateBegin = rs.getDate("DateBegin");
                Date dateEnd = rs.getDate("DateEnd");
                dto = new DiscountDTO(code, status, dateBegin, dateEnd, salePercent);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public int loadSalePercentByCode(String code) throws SQLException, NamingException {
        int result = -1;
        try {
             String sql = "select SalePercent from Discount where DiscountCode = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            if(rs.next()) {
                result = rs.getInt("SalePercent");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
