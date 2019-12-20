/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.discount;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class DiscountDTO implements Serializable {
    private String discountCode, userID, status;
    private int salePercent;
    private Date dateBegin, dateEnd;

    public DiscountDTO(String discountCode, String userID, String status, int salePercent, Date dateBegin, Date dateEnd) {
        this.discountCode = discountCode;
        this.userID = userID;
        this.status = status;
        this.salePercent = salePercent;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    
}
