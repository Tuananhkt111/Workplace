/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.account;

import anhht.utils.MyConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import javax.naming.NamingException;

/**
 *
 * @author tuana
 */
public class AccountDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public AccountDTO checkLogin(String userID, String password) throws NamingException, SQLException {
        AccountDTO dto = null;
        try {
            String sql = "SELECT Role, Username FROM Account WHERE UserID = ? AND Password = ? AND Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, password);
            preStm.setString(3, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                dto = new AccountDTO();
                dto.setRole(rs.getString("Role"));
                dto.setUsername(rs.getString("Username"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insert(AccountDTO dto, InputStream is) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Insert into Account (UserID, Username, Password, Email, Phone, Photo, Role, Status) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserID());
            preStm.setString(2, dto.getUsername());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhone());
            preStm.setBlob(6, is);
            preStm.setString(7, dto.getRole());
            preStm.setString(8, "Active");
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(AccountDTO dto, InputStream is) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Account set Username = ?, Email = ?, Phone = ?, Photo = ?, Role = ? where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(6, dto.getUserID());
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhone());
            preStm.setBlob(4, is);
            preStm.setString(5, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean update(String pass, String id) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Account set Password = ? where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pass);
            preStm.setString(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean update(AccountDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "update Account set Username = ?, Email = ?, Phone = ?, Role = ? where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(5, dto.getUserID());
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhone());
            preStm.setString(4, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ArrayList<String> loadAllRole() throws NamingException, SQLException {
        ArrayList<String> list = null;
        try {
            String sql = "select distinct Role from Account";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString("Role"));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<AccountDTO> loadAccount(String role, String name) throws NamingException, SQLException, IOException {
        ArrayList<AccountDTO> list = null;
        try {
            String sql = "select UserID, Username, Password, Email, Phone, Photo from Account where Role = ? and Username LIKE ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, role);
            preStm.setString(2, "%" + name + "%");
            preStm.setString(3, "Active");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("UserID");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                Blob photo = rs.getBlob("Photo");
                AccountDTO dto;
                if (photo != null) {
                    ByteArrayOutputStream outputStream;
                    byte[] imageBytes;
                    String base64Image;
                    try (InputStream inputStream = photo.getBinaryStream()) {
                        outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }   
                        imageBytes = outputStream.toByteArray();
                        base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    }
                    outputStream.close();
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active", imageBytes);
                    dto.setBase64Img(base64Image);
                } else {
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active");
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ArrayList<AccountDTO> loadAccount(String name) throws NamingException, SQLException, IOException {
        ArrayList<AccountDTO> list = null;
        try {
            String sql = "select UserID, Username, Password, Email, Phone, Role, Photo from Account where Username LIKE ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            preStm.setString(2, "Active");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("UserID");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String role = rs.getString("Role");
                Blob photo = rs.getBlob("Photo");
                AccountDTO dto;
                if (photo != null) {
                    ByteArrayOutputStream outputStream;
                    byte[] imageBytes;
                    String base64Image;
                    try (InputStream inputStream = photo.getBinaryStream()) {
                        outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }   
                        imageBytes = outputStream.toByteArray();
                        base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    }
                    outputStream.close();
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active", imageBytes);
                    dto.setBase64Img(base64Image);
                } else {
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active");
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public AccountDTO loadAccountByUserID(String userID) throws NamingException, SQLException, IOException {
        AccountDTO dto = null;
        try {
            String sql = "select Username, Password, Email, Phone, Photo, Role from Account where UserID = ? and Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, "Active");
            rs = preStm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String role = rs.getString("Role");
                Blob photo = rs.getBlob("Photo");
                if (photo != null) {
                    ByteArrayOutputStream outputStream;
                    byte[] imageBytes;
                    String base64Image;
                    try (InputStream inputStream = photo.getBinaryStream()) {
                        outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }   
                        imageBytes = outputStream.toByteArray();
                        base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    }
                    outputStream.close();
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active", imageBytes);
                    dto.setBase64Img(base64Image);
                } else {
                    dto = new AccountDTO(userID, username, password, email, phone, role, "Active");
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean delete(String userID) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Update Account set Status = ? where UserID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Inactive");
            preStm.setString(2, userID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
