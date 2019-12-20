/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author popem
 */
public class MyConnection {
    public static Connection getMyConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:11111;databaseName=Project", "sa", "12345");
        return conn;
    }
}
