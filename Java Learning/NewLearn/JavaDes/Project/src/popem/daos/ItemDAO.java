/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.daos;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import popem.db.MyConnection;
import popem.dtos.ItemDTO;
/**
 *
 * @author popem
 */
public class ItemDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public List<String> findAllItems() throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "Select ID, Name from Item";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery(); 
            while(rs.next()){
                list.add(rs.getString("ID")+"-"+rs.getString("Name"));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ItemDTO getGameplayStats(String id) throws Exception{
        ItemDTO dto = null;
        String sql = "Select Time_Modifier, Points_Modifier, Question_Modifier, Drop_Rate from Item "
                + "where ID = ?";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery(); 
            if(rs.next()){
                dto = new ItemDTO(id,rs.getFloat("Drop_Rate"),rs.getFloat("Time_Modifier") ,rs.getFloat("Points_Modifier"), rs.getBoolean("Question_Modifier"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    
    public ItemDTO findByPrimaryKey(String id) throws  Exception{
        ItemDTO dto = null;
        String sql = "Select ID, Name, Description, Drop_Rate from Item "
                + "where ID = ?";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery(); 
            if(rs.next()){
                dto = new ItemDTO(rs.getString("ID") ,rs.getString("Name"), rs.getString("Description"),rs.getFloat("Drop_Rate"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
