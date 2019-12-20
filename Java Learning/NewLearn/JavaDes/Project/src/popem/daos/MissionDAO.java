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
import popem.dtos.MissionDTO;


/**
 *
 * @author popem
 */
public class MissionDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
 
    public List<MissionDTO> findByAttribute(String attribute,String keyword) throws Exception {
        List<MissionDTO> list = null;
        try {
            if (attribute.equals("Points")){
                String sql = "Select ID, Name, Rank, Item from Mission "
                    + "where Points = "+keyword;
                conn = MyConnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
            }
            else if (attribute.equals("All")){
                String sql = "Select ID, Name, Rank, Item from Mission";
                conn = MyConnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
            } else {
                String sql = "Select ID, Name, Rank, Item from Mission "
                        + "where "+attribute+" like ?";
                conn = MyConnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "%"+keyword+"%");
                rs = preStm.executeQuery();            
            }
            list = new ArrayList<>();
            while (rs.next()){
                list.add(new MissionDTO(rs.getString("ID"),rs.getString("Name"),rs.getString("Rank"),rs.getString("Item")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public MissionDTO findByPrimaryKey(String id) throws Exception{
        MissionDTO dto = null;
        try {
            String sql = " Select * from Mission "
                    + "where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                dto = new MissionDTO(id, rs.getString("Question"), rs.getString("Choice_1")
                        ,rs.getString("Choice_2"), rs.getString("Choice_3"), rs.getString("Type")
                        ,rs.getString("Item"),rs.getString("Answer"),rs.getString("Name"),rs.getString("Rank"),rs.getInt("Points"));
            }
        } finally  {
            closeConnection();
        }
        return dto;
    }
    
    public boolean create(MissionDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Insert into Mission "
                    + "(ID, Question, Choice_1, Choice_2, Choice_3, Answer, Type, Points, Item, Name, Rank) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getQuestion());
            preStm.setString(3, dto.getChoice1());
            preStm.setString(4, dto.getChoice2());
            preStm.setString(5, dto.getChoice3());
            preStm.setString(6, dto.getAnswer());
            preStm.setString(7, dto.getType());
            preStm.setInt(8, dto.getPoints());
            preStm.setString(9, dto.getItem());
            preStm.setString(10, dto.getName());
            preStm.setString(11, dto.getRank());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean update(MissionDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Mission "
                    + "set Question = ?, Choice_1 = ?, Choice_2 = ? , Choice_3 = ?, Answer = ? , Type = ?, Points = ?, Item= ? , Name = ?, Rank = ? "
                    + "where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(11, dto.getId());
            preStm.setString(1, dto.getQuestion());
            preStm.setString(2, dto.getChoice1());
            preStm.setString(3, dto.getChoice2());
            preStm.setString(4, dto.getChoice3());
            preStm.setString(5, dto.getAnswer());
            preStm.setString(6, dto.getType());
            preStm.setInt(7, dto.getPoints());
            preStm.setString(8, dto.getItem());
            preStm.setString(9, dto.getName());
            preStm.setString(10, dto.getRank());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String id) throws Exception{
        boolean check = false;
        try {
            String sql = "Delete from Mission "
                    + "where id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    
}
