/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.action;

import java.sql.ResultSet;
import ots.test.beans.Admin;
import ots.test.dao.Admindao;

/**
 *
 * @author prasun
 */
public class AdminAction {
    private int adminId;
    private String adminPassword;
    private String adminName;
    private String adminEmail;
    private boolean validAdmin;
    private String msg = "";
   
    public String login() throws Exception {
         Admin admin = new Admin();
        Admin  validAdmin = Admindao.validateLoginCredentials(admin); 
        if(validAdmin.isValidAdmin()){
            setMsg("Welcome");
        }else{
            setMsg("Error");
        }
        return "Login";
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
     * @return the admin
     */
   
    
    
}
