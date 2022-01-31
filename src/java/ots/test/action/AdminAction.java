/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.Map;
import ots.test.beans.Admin;
import ots.test.dao.AdminDao;

/**
 *
 * @author prasun
 */
public class AdminAction extends ActionSupport {

    private int adminId;
    private String adminPassword;
    private String adminName;
    private String adminEmail;
    private boolean validAdmin;
    private AdminDao admindao = null;
    private String msg = "";

    private String login = "";
//private String LoginAdmin="success";

    public String loginAdmin() throws Exception {
        admindao = new AdminDao();

        Admin admin = admindao.validateLoginCredentials(adminEmail, adminPassword);
        System.out.println("login Action " + admin);
        if (admin != null) {
            adminId = admin.getAdminId();
            adminPassword = admin.getAdminPassword();
//adminName = admin.getAdminName();
            adminEmail = admin.getAdminEmail();
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("adminname", admin.getAdminName());
            return "LoginAdmin";
//login = "LoginAdmin";
        } else {
            setMsg("Error");
            return "Failure";
//login = "Failure";
        }

//setMsg("Welcome");
//return login;
    }

    public String logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("adminname");
// if (session.containsKey("adminname")) {
// session.remove("adminname");
// //login = "Failure";
// }
        System.out.println("adminname");
        return "LoginAdmin";
    }

    /**
     * @return the adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * @return the adminPassword
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * @param adminPassword the adminPassword to set
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * @return the adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * @return the adminEmail
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * @param adminEmail the adminEmail to set
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     * @return the validAdmin
     */
    public boolean isValidAdmin() {
        return validAdmin;
    }

    /**
     * @param validAdmin the validAdmin to set
     */
    public void setValidAdmin(boolean validAdmin) {
        this.validAdmin = validAdmin;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the admindao
     */
    public AdminDao getAdmindao() {
        return admindao;
    }

    /**
     * @param admindao the admindao to set
     */
    public void setAdmindao(AdminDao admindao) {
        this.admindao = admindao;
    }

    /**
     * @return the admin
     */
}
