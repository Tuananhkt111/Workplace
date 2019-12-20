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
import popem.dtos.AccountDTO;

/**
 *
 * @author popem
 */
public class AccountDAO {
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception{
        if (rs!= null) rs.close();
        if (preStm!= null) preStm.close();
        if (conn!= null) conn.close();
    }
    
    public List<AccountDTO> findByAttribute(String attribute,String keyword) throws Exception {
        List<AccountDTO> list = null;
        try {
            if (attribute.equals("All")){
                String sql = "Select Character_Name,Rank,Character_Class,Username from Account";
                conn = MyConnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
            } else {
                String sql = "Select Character_Name,Rank,Character_Class,Username from Account "
                        + "where "+attribute+" like ?";
                conn = MyConnection.getMyConnection();
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "%"+keyword+"%");
                rs = preStm.executeQuery();            
            }
            list = new ArrayList<>();
            while (rs.next()){
                list.add(new AccountDTO(rs.getString("Character_Name"),rs.getString("Rank"),rs.getString("Character_Class"),rs.getString("Username")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public AccountDTO findByPrimaryKey(String username) throws Exception{
        AccountDTO dto = null;
        try {
            String sql = " Select * from Account "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next()){
                dto = new AccountDTO(username, rs.getString("Password"), rs.getString("Rank")
                        ,rs.getString("Role"), rs.getString("Character_class")
                        , rs.getString("Character_name"), rs.getInt("Points"));
            }
        } finally  {
            closeConnection();
        }
        return dto;
    }
    
    public List<AccountDTO> findTopPlayers() throws Exception{
        List<AccountDTO> list = null;
        try {
            String sql = "Select Character_Name, Rank, Character_Class, Points, username, role from Account "
                    + " order by points desc";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                list.add(new AccountDTO(rs.getString("username"),rs.getString("rank"),rs.getString("Character_Class"),rs.getString("Character_Name"),rs.getInt("Points"), rs.getString("Role")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean create(AccountDTO dto) throws Exception{
        boolean check = false;
        try{
            String sql = "Insert into Account "
                    + "(username, password, Character_name"
                    + ", Character_Class, Role, Rank, Points) "
                    + "values (?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getCharacterName());
            preStm.setString(4, dto.getCharacterClass());
            preStm.setString(5, dto.getRole());
            preStm.setString(6, dto.getRank());
            preStm.setInt(7, dto.getPoints());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean update(AccountDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Account "
                    + "set username = ?, Password = ?, Character_Name = ? "
                    + ", Points = ?, Role = ? , Character_Class = ?, Rank = ? "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getCharacterName());
            preStm.setInt(4, dto.getPoints());
            preStm.setString(5, dto.getRole());
            preStm.setString(6, dto.getCharacterClass());
            preStm.setString(7, dto.getRank());
            preStm.setString(8, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateCharacterCreation(String username ,String characterName, String characterClass) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Account set "
                    + "Character_Name = ?, "
                    + "Character_Class = ?, "
                    + "Points = 0 "
                    + "where username = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, characterName);
            preStm.setString(2, characterClass);
            preStm.setString(3, username);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateAfterMission(int points, String username, String rank) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Account set "
                    + "points = ?, rank = ? "
                    + "where username = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, points);
            preStm.setString(2, rank);
            preStm.setString(3, username);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean changePassword(String username, String password) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Account set "
                    + "password = ? "
                    + "where username = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String username) throws Exception{
        boolean check = false;
        try {
            String sql = "Delete from Account "
                    + "where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
