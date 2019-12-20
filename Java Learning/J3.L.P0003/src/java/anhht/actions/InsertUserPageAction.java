/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.role.RoleDAO;
import anhht.role.RoleDTO;
import java.sql.SQLException;
import java.util.ArrayList;
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
    @Result(name = "success", location = "insertUser.jsp")
    ,
    @Result(name = "error", location = "error.jsp")
})
public class InsertUserPageAction {

    private static final Logger LOGGER = Logger.getLogger(InsertUserPageAction.class);
    private String msg;
    private ArrayList<RoleDTO> roleList;

    public InsertUserPageAction() {
    }

    @Action("InsertUserPageAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            RoleDAO dao = new RoleDAO();
            roleList = dao.loadRole();
            if(roleList == null|| roleList.isEmpty()) {
                msg = "Load role failed";
            } else {
                url = "success";
            }
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at InsertUserPageAction: " + e.getMessage());
            msg = "ERROR at InsertUserPageAction";
        }
        return url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(ArrayList<RoleDTO> roleList) {
        this.roleList = roleList;
    }

}
