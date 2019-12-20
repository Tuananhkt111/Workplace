/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
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
    @Result(name = "success", location = "SearchAction", type = "redirectAction")})
public class LogoutAction {
    private static final Logger LOGGER = Logger.getLogger(LogoutAction.class);
    private String msg;
    public LogoutAction() {
    }
    @Action("LogoutAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.invalidate();
            url = "success";
        } catch (Exception e) {
            LOGGER.error("ERROR at LogoutAction: " + e.getMessage());
            msg = "ERROR at LogoutAction";
        }
        return url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
