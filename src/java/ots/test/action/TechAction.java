/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.action;

//import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import ots.test.beans.Tech;
import ots.test.dao.TechDao;

/**
 *
 * @author a-cube
 */
public class TechAction extends ActionSupport{

    private String techName;
    private String techEmail;
    private String techPassword;
    private String ticketLevel;
    private TechDao techdao = null;
    private boolean validTech;
    private String msg = "";
    private int ctr = 0;
    private String login = "";

    public String loginTech() throws Exception {

        techdao = new TechDao();
        Tech validTech = techdao.validateLoginCredentials(techEmail, techPassword);
        System.out.println("login Action " + validTech);
        if (validTech != null) {
            techName = validTech.getTechName();
            techEmail = validTech.getTechEmail();
            techPassword = validTech.getTechPassword();
            ticketLevel = validTech.getTicketLevel();
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("techname", validTech.getTechName());
            login = "LoginTech";
        } else {
            setMsg("Error");
            login = "FailureTech";
        }
        return login;
    }

    public String logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("techname");
// if (session.containsKey("adminname")) {
// session.remove("adminname");
// //login = "Failure";
// }
        System.out.println("techname");
        return "LogoutTech";
    }
    public String registerTech() {

        TechDao tech = new TechDao();

        try {
            setCtr(tech.addTech(getTechName(), getTechEmail(), getTechPassword(), getTicketLevel()));
            if (getCtr() > 0) {
                setMsg("Tech Added");
            } else {
                setMsg("Unable to add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "RegisterTech";
    }

    public boolean isValidTech() {
        return validTech;
    }

    /**
     * @param validTech the validTech to set
     */
    public void setValidTech(boolean validTech) {
        this.validTech = validTech;
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
    public String getTechPassword() {
        return techPassword;
    }

    /**
     * @param techPassword the techPassword to set
     */
    public void setTechPassword(String techPassword) {
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
    public void setTicketLevel(String ticketLevel) {
        this.ticketLevel = ticketLevel;
    }

}
