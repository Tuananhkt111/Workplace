/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dtos;

import anhht.daos.CarDAO;
import anhht.daos.EmpDAO;
import anhht.daos.TravelPriceDAO;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class TravelTransactionDTO implements Serializable {

    private String transID, travelID, cusID, empID, carSerial;
    private int price, duration;
    private Timestamp startTime, endTime;

    public TravelTransactionDTO(String transID, String travelID, String cusID, String empID, String carSerial, int price, int duration, Timestamp startTime) {
        this.transID = transID;
        this.travelID = travelID;
        this.cusID = cusID;
        this.empID = empID;
        this.carSerial = carSerial;
        this.price = price;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = new Timestamp(startTime.getTime() + duration*3600000);
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    
    public String getCarName() {
        String result = "";
        try {
            CarDAO carDAO = new CarDAO();
            CarDTO carDTO = carDAO.findByPrimaryKey(carSerial);
            result = carDTO.getName();
        } catch (Exception e) {
        }
        return result;
    }

    public String getDestination() {
        String result = "";
        try {
            TravelPriceDAO tpDAO = new TravelPriceDAO();
            TravelPriceDTO tpDTO = tpDAO.findByPrimaryKey(travelID);
            result = tpDTO.getDestination();
        } catch (Exception e) {
        }
        return result;
    }

    public int getNumberOfSeats() {
        int result = 0;
        try {
            TravelPriceDAO tpDAO = new TravelPriceDAO();
            TravelPriceDTO tpDTO = tpDAO.findByPrimaryKey(travelID);
            result = tpDTO.getNumberOfSeats();
        } catch (Exception e) {
        }
        return result;

    }

    public String getDriver() {
        String result = "";
        try {
            EmpDAO empDAO = new EmpDAO();
            EmployeeDTO empDTO = empDAO.findByPrimaryKey(empID);
            result = empDTO.getName();
        } catch (Exception e) {

        }
        return result;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTravelID() {
        return travelID;
    }

    public void setTravelID(String travelID) {
        this.travelID = travelID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getCarSerial() {
        return carSerial == null ? "" : carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(transID);
        v.add(cusID);
        v.add(getDestination());
        v.add(getNumberOfSeats());
        v.add(getCarSerial());
        v.add(getCarName());
        v.add(getDriver());
        v.add(startTime);
        v.add(duration);
        v.add(price);
        return v;
    }
}
