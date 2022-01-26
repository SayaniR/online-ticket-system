/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ots.test.beans.Tech;
import ots.test.dao.Techdao;

/**
 *
 * @author a-cube
 */
public class TechAction extends ActionSupport{
    private String msg = "";
    private int ctr = 0;
    
    private int techId;
    private String techName;
    private String techEmail;
    private String techPassword;
    private String ticketLevel;
    
    private String submitType;

    private static long serialVersionUID = 6329394260276112660L;
    private ResultSet rs = null;
    private Tech tech = null;
    private List<Tech> techList = null;
    private Techdao admin = new Techdao();
    private boolean noData = false;

    
    public String getAllTech() throws Exception {
        try {
            setTechList(new ArrayList<>());
            setTechList(admin.techList());
            

            if (!techList.isEmpty() ) {
                setNoData(false);
                System.out.println("Users retrieve = "+getTechList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TECHLIST";
    }

    /**
     * @return the techList
     */
    public List<Tech> getTechList() {
        return techList;
    }

    /**
     * @param techList the techList to set
     */
    public void setTechList(List<Tech> techList) {
        this.techList = techList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }


public String addTech(){
        Techdao tech = new Techdao();
        try{
            setCtr(tech.addTech(getTechName(), getTechEmail(), getPassword(), getTicketLevel()));
            if (getCtr() > 0) {
                setMsg("Tech Added Successfull");
            } else {
                setMsg("Some error");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ADDED";
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
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    /**
     * @return the techId
     */
    public int getTechId() {
        return techId;
    }

    /**
     * @param techId the techId to set
     */
    public void setTechId(int techId) {
        this.techId = techId;
    }

    /**
     * @return the techName
     */
    public String getTechName() {
        return techName;
    }

    /**
     * @param techName the techName to set
     */
    public void setTechName(String techName) {
        this.techName = techName;
    }

    /**
     * @return the techEmail
     */
    public String getTechEmail() {
        return techEmail;
    }

    /**
     * @param techEmail the techEmail to set
     */
    public void setTechEmail(String techEmail) {
        this.techEmail = techEmail;
    }

    /**
     * @return the techPassword
     */
    public String getPassword() {
        return techPassword;
    }

    /**
     * @param techPassword the techPassword to set
     */
    public void setPassword(String techPassword) {
        this.techPassword = techPassword;
    }

    /**
     * @return the ticketLevel
     */
    public String getTicketLevel() {
        return ticketLevel;
    }

    /**
     * @param ticketLevel the ticketLevel to set
     */
    public void setAvailability(String ticketLevel) {
        this.ticketLevel = ticketLevel;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the tech
     */
    public Tech getTech() {
        return tech;
    }

    /**
     * @param tech the tech to set
     */
    public void setTech(Tech tech) {
        this.tech = tech;
    }

    /**
     * @return the admin
     */
    public Techdao getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Techdao admin) {
        this.admin = admin;
    }
 public String updateTech(){
        Techdao tech=new Techdao();
        try {
            if (getSubmitType().equals("updatedata")) {
                Tech pro =tech.fetchTechDetails(techId);
                if (pro != null) {
                    techId = pro.getTechId();
                    techName = pro.getTechName();
                    techEmail = pro.getTechEmail();
                    techPassword = pro.getTechPassword();
                    ticketLevel =pro.getTicketLevel();
                }
            } 
                else {
                System.out.println("in else part Tech Name: "+techName);
                int i = tech.updateTechDetails(techId, techName, techEmail, techPassword, ticketLevel);
                if (i > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UPDATE";
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    
}
