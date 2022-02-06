/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.actions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import ots.test.beans.Tickets;
import ots.test.beans.Users;
import ots.test.dao.CsrDao;
import ots.test.dao.TechnicianDao;

/**
 *
 * @author prasun
 */
public class TechnicianAction {

    private int ticketId;
    private String type;
    private String equipmentType;

    private String description;
    private int assignedTo;
    private Date assignedDate;
    private int ticketStatusId;
    private Date solvedDate;

    private int userId;
    private String userFullName;
    private String email;
    private String password;
    private int roleId;
    private int statusId;
    private TechnicianDao techdao = null;
    private int ctr = 0;
    private String msg = "";
    private String submitType;
    //private TechnicianDao techniciandao = null;
    private List<Users> usersList = new ArrayList<>();
    private boolean noData = false;
    private List<Tickets> ticketsList = null;
    private static Logger log = Logger.getLogger(TechnicianAction.class);

    public String updateUser() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            if (getSubmitType().equals("updatedata")) {
                Tickets tickets = getTechdao().fetchTicketDetails(getTicketId());
                if (tickets != null) {
                    setTicketId(tickets.getTicketId());
                    setType(tickets.getType());
                    setEquipmentType(tickets.getEquipmentType());
                    setDescription(tickets.getDescription());
                    setAssignedTo(tickets.getAssignedTo());
                    setAssignedDate((Date) tickets.getAssignedDate());
                    setTicketStatusId(tickets.getTicketStatusId());
                    setSolvedDate((Date) tickets.getSolvedDate());

                }
            } else {
                int i = getTechdao().updateTicketDetails(getTicketId(), getType(), getEquipmentType(), getDescription(), getAssignedTo(), getAssignedDate(), getTicketStatusId(), getSolvedDate());
                if (i > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setMsg("error");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for TechnicianAction() method");
        return "UPDATETICKET";
        }
    }

    public String showTechnician() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        TechnicianDao tcd = new TechnicianDao();

        try {
            setTechdao(new TechnicianDao());
            setUsersList(new ArrayList<Users>());
            setUsersList(tcd.getActiveTech());
            if (!usersList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for TechnicianAction() method");
        return "ShowAllTech";
        }
    }

    public String showActiveTicketsToTech() {
        
        HttpSession session = ServletActionContext.getRequest().getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        }else{
        try {
            techdao = new TechnicianDao();
            //setTechniciandao(new Techniciandao());
            setTicketsList(new ArrayList<Tickets>());
            setTicketsList(techdao.getActiveTickets(getEmail()));
            if (!ticketsList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("This is log for TechnicianAction() method");
        return "ShowActiveTicketsToTech";
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
     * @return the techdao
     */
    public TechnicianDao getTechdao() {
        return techdao;
    }

    /**
     * @param techdao the techdao to set
     */
    public void setTechdao(TechnicianDao techdao) {
        this.techdao = techdao;
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

    /**
     * @return the techniciandao
     */
    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the equipmentType
     */
    public String getEquipmentType() {
        return equipmentType;
    }

    /**
     * @param equipmentType the equipmentType to set
     */
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the assignedTo
     */
    public int getAssignedTo() {
        return assignedTo;
    }

    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * @return the assignedDate
     */
    public Date getAssignedDate() {
        return assignedDate;
    }

    /**
     * @param assignedDate the assignedDate to set
     */
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    /**
     * @return the ticketStatusId
     */
    public int getTicketStatusId() {
        return ticketStatusId;
    }

    /**
     * @param ticketStatusId the ticketStatusId to set
     */
    public void setTicketStatusId(int ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    /**
     * @return the solvedDate
     */
    public Date getSolvedDate() {
        return solvedDate;
    }

    /**
     * @param solvedDate the solvedDate to set
     */
    public void setSolvedDate(Date solvedDate) {
        this.solvedDate = solvedDate;
    }

    /**
     * @return the usersList
     */
    public List<Users> getUsersList() {
        return usersList;
    }

    /**
     * @param usersList the usersList to set
     */
    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
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

}
