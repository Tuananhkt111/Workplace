/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tranh
 */
public class RegistrationDAO implements Serializable {

    public RegistrationDAO() {
    }

    public String findByLikeName(String search) throws Exception {
        String sql = "Select Username, Fullname, Role From tbl_Registration "
                + "Where Fullname LIKE ? FOR XML Path('account'), Root('accounts')";
        String result = "";
        String connString = "jdbc:sqlserver://localhost:1605;databaseName=Registration";
        String user = "sa";
        String pass = "123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection conn = DriverManager.getConnection(connString, user, pass);
                PreparedStatement preStm = conn.prepareStatement(sql)) {
            preStm.setString(1, "%" + search + "%");
            try (ResultSet rs = preStm.executeQuery()) {
                if (rs.next()) {
                    result = rs.getString(1);
                }
            }
        }
        return result;
    }
}
