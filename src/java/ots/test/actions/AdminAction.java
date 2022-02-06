/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import ots.test.beans.Technician;
import ots.test.beans.Tickets;
import ots.test.beans.Users;
import ots.test.dao.AdminDao;
import ots.test.dao.TechnicianDao;

/**
 *
 * @author prasun
 */
public class AdminAction {

    private int userId;
    private String userFullName;
    private String email;
    private String password;
    private int roleId;
    private int statusId;
    AdminDao admindao = new AdminDao();
    private List<Users> techAssign = null;
    Users users = null;
    private int ctr = 0;
    private String msg = "";
    private List<Users> csrList = null;
    private List<Users> techList = null;
    private List<Tickets> ticketsList = null;
    private boolean noData = false;
    private String level;
    private static Logger log = Logger.getLogger(AdminAction.class);
    
   
    
    public String register() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
             String returnstring = null;
        admindao = new AdminDao();
        try {
            setCtr(admindao.registration(getUserFullName(), getEmail(), getPassword(), getRoleId()));

            if (getCtr() > 0 && roleId == 2) {
                setMsg("CSR Added");
                returnstring = "RegisterCsr";
            } else if (getCtr() > 0 && roleId == 3) {
                setMsg("Technician Added");
                returnstring = "RegisterTech";
            } else {
                setMsg("Unable to add");
                returnstring = "Unabletoadd";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//return "RegisterCsr";
log.info("This is log for AdminAction() method");
        return returnstring;
        }
//CsrDao csr = new CsrDao();
       
    }

    public String deleteCsr() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            admindao = new AdminDao();
            int isDeleted = admindao.deleteCsrDetails(getEmail());
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some error";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "DeleteCsr";
        }

    }

    public String showActiveCsr() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {

            setCsrList(new ArrayList<Users>());
            setCsrList(admindao.getActiveCsr());
            if (!csrList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "ShowCsr";
        }
    }

//    public String registerTechnician() {
//        //CsrDao csr = new CsrDao();
//        //setCsrdao(new CsrDao());
//
//        try {
//            admindao = new AdminDao();
//            setCtr(admindao.addTechnician(getUserFullName(), getEmail(), getPassword(), getRoleId()));
//            if (getCtr() > 0) {
//                setMsg("Technician Added");
//            } else {
//                setMsg("Unable to add");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "RegisterTech";
//    }
    public String deleteTech() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            admindao = new AdminDao();
            int isDeleted = admindao.deleteTechnicianDetails(getEmail());
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some error";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "DeleteTech";
        }
    }

    public String showActiveTechnician() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            setTechList(new ArrayList<Users>());
            setTechList(admindao.getActiveTech());
            if (!techList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "ShowTech";
        }
    }

    public String showActiveTickets() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            setTicketsList(new ArrayList<Tickets>());
            setTicketsList(admindao.getActiveTickets());
            if (!ticketsList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "ShowActiveTickets";
        }
    }

    public String showClosedTickets() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            setTicketsList(new ArrayList<Tickets>());
            setTicketsList(admindao.getClosedTickets());
            if (!ticketsList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for AdminAction() method");
        return "ShowClosedTickets";
        }

    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userFullName
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     * @param userFullName the userFullName to set
     */
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the statusId
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
     * @return the userList
     */
    /**
     * @return the ticketsList
     */
    public List<Tickets> getTicketsList() {
        return ticketsList;
    }

    /**
     * @param ticketsList the ticketsList to set
     */
    public void setTicketsList(List<Tickets> ticketsList) {
        this.ticketsList = ticketsList;
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

    /**
     * @return the csrList
     */
    public List<Users> getCsrList() {
        return csrList;
    }

    /**
     * @param csrList the csrList to set
     */
    public void setCsrList(List<Users> csrList) {
        this.csrList = csrList;
    }

    /**
     * @return the techList
     */
    public List<Users> getTechList() {
        return techList;
    }

    /**
     * @param techList the techList to set
     */
    public void setTechList(List<Users> techList) {
        this.techList = techList;
    }

    public String assignTechnician() throws SQLException {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        
        setTechAssign(new ArrayList<Users>());
        setTechAssign(AdminDao.gettechnicianNameWithoutAssign());
        if (getTechAssign().isEmpty()) {
            setNoData(true);
            setMsg("List is empty");
            System.out.println("List is empty");
        } else {
            setNoData(false);
            //setMsg("Level Assigned");
            System.out.println("List have some data");
        }
// Product product=(Product) getProductList().get(0);
//System.out.println("Prodct Category: "+product.getCategory());
        return "technician";
        }
    }

    public String saveMappng() {
         HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        int id = userId;
        String techlevel = getLevel();
        System.out.println("UserId: " + id + "\n" + "Level: " + techlevel);
        int i = AdminDao.saveTechnicianMapping(id, techlevel);
        System.out.println("Affected rows: " + i);
        setMsg("Technician Mapped");
        return "Save";
        }
    }

    /**
     * @return the techAssign
     */
    public List<Users> getTechAssign() {
        return techAssign;
    }

    /**
     * @param techAssign the techAssign to set
     */
    public void setTechAssign(List<Users> techAssign) {
        this.techAssign = techAssign;
    }

    public String welcome() {
        return "welcome";
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }
}
