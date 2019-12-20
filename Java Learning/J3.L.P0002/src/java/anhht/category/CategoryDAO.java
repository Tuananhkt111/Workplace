/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.category;

import anhht.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class CategoryDAO implements Serializable {
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

    public ArrayList<CategoryDTO> loadCategory() throws NamingException, SQLException {
        ArrayList<CategoryDTO> list = null;
        try {
            String sql = "SELECT CatID, CatName FROM Category";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String catID = rs.getString("CatID");
                String catName = rs.getString("CatName");
                list.add(new CategoryDTO(catID, catName));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
