/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import popem.db.MyConnection;
import popem.dtos.CompletedMissionDTO;

/**
 *
 * @author popem
 */
public class CompletedMissionDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public List<CompletedMissionDTO> findByUsername(String username) throws Exception{
        List<CompletedMissionDTO> list = null;
        try {
            String sql = " Select Mission_ID, Highest_Score from Completed_Mission "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                list.add(new CompletedMissionDTO(username, rs.getString("Mission_ID"), rs.getInt("Highest_Score")));
            }
        } finally  {
            closeConnection();
        }
        return list;
    }
    public CompletedMissionDTO findByPrimaryKey(String username, String mission) throws Exception{
        CompletedMissionDTO dto = null;
        try {
            String sql = " Select Highest_Score from Completed_Mission "
                    + "where username = ? and Mission_ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, mission);
            rs = preStm.executeQuery();
            if (rs.next()){
                dto = new CompletedMissionDTO(username, mission, rs.getInt("Highest_Score"));
            }
        } finally  {
            closeConnection();
        }
        return dto;
    }
    public boolean create(String username, String mission, int points) throws Exception{
        boolean check = false;
        try{
            String sql = "Insert into Completed_Mission "
                    + "(username, Mission_ID, Highest_Score) "
                    + "values (?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, mission);
            preStm.setInt(3, points);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean update(String username, String mission, int highScore) throws Exception{
        boolean check = false;
        try{
            String sql = "Update Completed_Mission "
                    + "set Highest_Score = ? "
                    + "where username = ? and Mission_ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, highScore);
            preStm.setString(2, username);
            preStm.setString(3, mission);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
}
