/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.daos;

import anhht.db.MyConnection;
import anhht.dtos.NewsDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author popemkt
 */
public class NewsDAO  implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public NewsDAO() {
    }
    public void closeConnection() throws Exception{
        if (rs!= null) {
            rs.close();
        }
        if (preStm!= null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public boolean insert(NewsDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Insert into TBL_News(ID, Title, ShortDescription, Description, TimeOfCreate, Author, IsApproved) values(?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getTitle());
            preStm.setString(3, dto.getShortDes());
            preStm.setString(4, dto.getDes());
            Date date = dto.getTimeOfCreate();
            java.sql.Date myDate = new java.sql.Date(date.getTime());
            preStm.setDate(5, myDate);
            preStm.setString(6, dto.getAuthor());
            preStm.setBoolean(7, dto.isIsApproved());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    
}
