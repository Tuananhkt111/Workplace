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
public class MyConnection implements Serializable{
    public static Connection getMyConnection(){
        Connection conn = null;
        try {
            //1. Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. Khởi tạo connection
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:11111;databaseName=tunkun", "tunkun", "111999");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
