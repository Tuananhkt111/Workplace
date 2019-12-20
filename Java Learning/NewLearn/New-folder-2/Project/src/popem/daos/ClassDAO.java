/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import popem.db.MyConnection;
import popem.dtos.ClassDTO;

/**
 *
 * @author popem
 */
public class ClassDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public ClassDTO findByPrimaryKey(String classname) throws Exception{
        ClassDTO dto = null;
        try {
            String sql = " Select Description, Point_Modifier, Time_Modifier, Question_Modifier from Class "
                    + "where Name = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, classname);
            rs = preStm.executeQuery();
            if(rs.next()){
                dto = new ClassDTO(classname, rs.getString("Description"), rs.getFloat("Point_Modifier")
                        ,rs.getFloat("Time_Modifier"), rs.getBoolean("Question_Modifier"));
            }
        } finally  {
            closeConnection();
        }
        return dto;
    }
    
}
