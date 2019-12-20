/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tuana
 */
public class MyConnection implements Serializable{
    public static Connection getMyConnection() throws Exception{
        //1.Initialize driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2.Create connection
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:11111;databaseName=BookingCarService", "tunkun", "123");
        return conn;
    }
}
