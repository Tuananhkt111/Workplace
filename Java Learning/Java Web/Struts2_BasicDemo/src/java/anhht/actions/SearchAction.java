/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.daos.RegistrationDAO;
import anhht.dtos.RegistrationDTO;
import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class SearchAction {
    private String searchValue;
    private ArrayList<RegistrationDTO> list;
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        list = dao.search(searchValue);
        return "success";
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public ArrayList<RegistrationDTO> getList() {
        return list;
    }

    public void setList(ArrayList<RegistrationDTO> list) {
        this.list = list;
    }

}
