/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.roomtype.RoomTypeDAO;
import anhht.roomtype.RoomTypeDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author tuana
 */
@ResultPath("/")
@Results({
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "searchRoom.jsp")})
public class SearchRoomAction {

    private static final Logger LOGGER = Logger.getLogger(SearchRoomAction.class);
    private String txtHotelID, txtHotelName, txtCheckinDate, txtCheckoutDate;
    private int txtQuantity;
    private String msg;
    private ArrayList<RoomTypeDTO> roomTypeList;

    public SearchRoomAction() {
    }

    @Action("SearchRoomAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            RoomTypeDAO rtDAO = new RoomTypeDAO();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = format.parse(txtCheckinDate);
            Date endDate = format.parse(txtCheckoutDate);
            roomTypeList = rtDAO.searchRoomTypeByHotelID(txtHotelID, beginDate, endDate, txtQuantity);
            url = "success";
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at SearchRoomAction: " + e.getMessage());
            msg = "ERROR at SearchRoomAction";
        }
        return url;
    }

    public String getTxtHotelID() {
        return txtHotelID;
    }

    public void setTxtHotelID(String txtHotelID) {
        this.txtHotelID = txtHotelID;
    }

    public String getTxtHotelName() {
        return txtHotelName;
    }

    public void setTxtHotelName(String txtHotelName) {
        this.txtHotelName = txtHotelName;
    }

    public String getTxtCheckinDate() {
        return txtCheckinDate;
    }

    public void setTxtCheckinDate(String txtCheckinDate) {
        this.txtCheckinDate = txtCheckinDate;
    }

    public String getTxtCheckoutDate() {
        return txtCheckoutDate;
    }

    public void setTxtCheckoutDate(String txtCheckoutDate) {
        this.txtCheckoutDate = txtCheckoutDate;
    }

    public int getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(int txtQuantity) {
        this.txtQuantity = txtQuantity;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<RoomTypeDTO> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(ArrayList<RoomTypeDTO> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

}
