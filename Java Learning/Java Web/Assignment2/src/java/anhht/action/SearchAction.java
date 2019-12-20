package anhht.action;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import anhht.dao.AccessoryDAO;
import anhht.dto.AccessoryDTO;
import java.util.List;

/**
 *
 * @author tuana
 */
public class SearchAction {

    private String searchValue;
    private List<AccessoryDTO> list;
    private static final String SUCCESS = "success";
    public SearchAction() {
    }

    public String execute() throws Exception {
        AccessoryDAO dao = new AccessoryDAO();
        list = dao.findByBrandNotDelete(searchValue);
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<AccessoryDTO> getList() {
        return list;
    }

    public void setList(List<AccessoryDTO> list) {
        this.list = list;
    }

}
