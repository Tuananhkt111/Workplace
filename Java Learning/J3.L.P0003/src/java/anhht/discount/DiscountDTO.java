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
    private String discountCode, status;
    private Date dateBegin, dateEnd;
    private int salePercent;

    public DiscountDTO(String discountCode, String status, Date dateBegin, Date dateEnd, int salePercent) {
        this.discountCode = discountCode;
        this.status = status;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.salePercent = salePercent;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }
    
}
