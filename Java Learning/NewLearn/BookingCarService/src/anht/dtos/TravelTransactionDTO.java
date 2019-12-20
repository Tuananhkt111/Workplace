/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.dtos;

import anht.daos.CarDAO;
import anht.daos.EmpDAO;
import anht.daos.TravelPriceDAO;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class TravelTransactionDTO implements Serializable {

    private String transID, travelID, accID, empID, carSerial, carName, status;
    private int price, duration;
    private Timestamp startTime;

    public TravelTransactionDTO(String transID, String travelID, String accID, String empID, String carSerial, String carName, String status, int price, int duration, Timestamp startTime) {
        this.transID = transID;
        this.travelID = travelID;
        this.accID = accID;
        this.empID = empID;
        this.carSerial = carSerial;
        this.carName = carName;
        this.status = status;
        this.price = price;
        this.duration = duration;
        this.startTime = startTime;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        v.add(getDestination());
        v.add(getNumberOfSeats());
        v.add(getCarSerial());
        v.add(carName);
        v.add(getDriver());
        v.add(startTime);
        v.add(duration);
        v.add(price);
        v.add(status);
        return v;
    }
}
