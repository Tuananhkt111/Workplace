/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.models;

import dungth.dao.RegistrationDAO;
import dungth.dtos.RegistrationDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hoang Dung
 */
public class ProcessBean implements Serializable {

    private String username, password;
    private String search;
    private RegistrationDTO dto;
    
    public ProcessBean() {
    }

    public RegistrationDTO getDto() {
        return dto;
    }

    public void setDto(RegistrationDTO dto) {
        this.dto = dto;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkLogin() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }
    public List<RegistrationDTO> findByLikeName() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.findByLikeName(search);
    }
    public boolean delete() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.delete(username);
    }
    public RegistrationDTO findByPrimaryKey() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.findByPrimaryKey(username);
    }
    public boolean update() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.update(dto);
    }
    public boolean insert() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.insert(dto);
    }
}
