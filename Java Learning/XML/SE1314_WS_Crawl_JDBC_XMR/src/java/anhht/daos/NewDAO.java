/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.dtos.NewDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuana
 */
public class NewDAO implements Serializable {

    private static final String connString = "jdbc:sqlserver://localhost:11111;databaseName=XML";
    private static final String user = "sa";
    private static final String pass = "12345";

    public NewDAO() {
    }

    public boolean insertNew(NewDTO dto) throws Exception {
        boolean check = false;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String sql = "Insert Into tbl_VnExpress(Title, Description, Link, PubDate) "
                + "values(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(connString, user, pass);) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getDescription());
            ps.setString(3, dto.getLink());
            ps.setString(4, dto.getPubDate());
            check = ps.executeUpdate() > 0;
        }
        return check;
    }
    
    public List<NewDTO> findByLikeTitle(String search) throws Exception {
        List<NewDTO> list = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String sql = "Select Id, Title, Description, Link, PubDate From tbl_VnExpress "
                + "Where Title LIKE ?";
        try (Connection conn = DriverManager.getConnection(connString, user, pass);) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            try(ResultSet rs = ps.executeQuery()) {
                list = new ArrayList<>();
                while(rs.next()) {
                    int id = rs.getInt("Id");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    String link = rs.getString("Link");
                    String pubDate = rs.getString("PubDate");
                    NewDTO dto = new NewDTO(id, title, description, link, pubDate);
                    list.add(dto);
                }
            }
        }
        return list;
    }
}
