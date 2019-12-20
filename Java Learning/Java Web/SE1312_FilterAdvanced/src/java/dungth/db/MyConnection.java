/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hoang Dung
 */
public class MyConnection implements Serializable {

    public static Connection getMyConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:11111;databaseName=Sinhvien", "sa", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
