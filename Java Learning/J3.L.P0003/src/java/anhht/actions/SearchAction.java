/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.hotel.HotelDAO;
import anhht.hotel.HotelDTO;
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
    @Result(name = "success", location = "search.jsp")})
public class SearchAction {

    private static final Logger LOGGER = Logger.getLogger(SearchAction.class);
    private String txtSearch, txtArea, txtName, txtCheckinDate, txtCheckoutDate;
    private String beginDateText, endDateText;
    private int txtQuantity;
    private String msg;
    private ArrayList<HotelDTO> hotelList;

    public SearchAction() {
    }

    @Action("SearchAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            HotelDAO hDAO = new HotelDAO();
            Date beginDate = new Date();
            Date endDate = new Date(beginDate.getTime() + 86400000);
            beginDateText = format.format(beginDate);
            endDateText = format.format(endDate);
            if (txtSearch == null) {
                txtCheckinDate = format.format(beginDate);
                txtCheckoutDate = format.format(endDate);
                txtQuantity = 1;
                hotelList = hDAO.searchHotelByArea("", beginDate, endDate, 1);
            } else if (txtSearch.equals("HotelName")) {
                beginDate = format.parse(txtCheckinDate);
                endDate = format.parse(txtCheckoutDate);
                hotelList = hDAO.searchHotelByName(txtName, beginDate, endDate, txtQuantity);
            } else if (txtSearch.equals("HotelArea")) {
                beginDate = format.parse(txtCheckinDate);
                endDate = format.parse(txtCheckoutDate);
                hotelList = hDAO.searchHotelByArea(txtArea, beginDate, endDate, txtQuantity);
            }
            url = "success";
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at SearchAction: " + e.getMessage());
            msg = "ERROR at SearchAction";
        }
        return url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(String txtSearch) {
        this.txtSearch = txtSearch;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
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

    public ArrayList<HotelDTO> getHotelList() {
        return hotelList;
    }

    public void setHotelList(ArrayList<HotelDTO> hotelList) {
        this.hotelList = hotelList;
    }

    public String getBeginDateText() {
        return beginDateText;
    }

    public void setBeginDateText(String beginDateText) {
        this.beginDateText = beginDateText;
    }

    public String getEndDateText() {
        return endDateText;
    }

    public void setEndDateText(String endDateText) {
        this.endDateText = endDateText;
    }

}
