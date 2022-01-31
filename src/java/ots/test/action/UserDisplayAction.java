/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ots.test.beans.UserDisplay;
import ots.test.dao.UserDisplayDao;

/**
 *
 * @author Home
 */
public class UserDisplayAction {

    private int issueId;
    private Date serviceDate;
    private String serviceDescription;
    private String ticketStatus;
    private String msg = "";
    private int ctr = 0;
    private UserDisplayDao userdisplaydao = null;
    private boolean noData = false;
    private List<UserDisplay> usdList = new ArrayList<>();

    public String userDisplayEnter() throws Exception {
        setUserdisplaydao(new UserDisplayDao());

        try {
            setCtr(getUserdisplaydao().enterUserDisplay(getIssueId(), getServiceDate(), getServiceDescription(), getTicketStatus()));
            if (getCtr() > 0) {
                setMsg("userd display successfully entered");
            } else {
                setMsg("try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "USERDISPLAYENTERED";
    }

    public String show() throws Exception {
        UserDisplayDao usd = new UserDisplayDao();
        try {
            setUsdList(new ArrayList<>());
            setUsdList(usd.showUserDisplay(getIssueId()));
            if (!usdList.isEmpty()) {
                setNoData(false);
                System.out.println("user display info showing = " + getUsdList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SHOWUSERDISPLAY";
    }

    /**
     * @return the issueId
     */
    public int getIssueId() {
        return issueId;
    }

    /**
     * @param issueId the issueId to set
     */
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    /**
     * @return the serviceDate
     */
    public Date getServiceDate() {
        return serviceDate;
    }

    /**
     * @param serviceDate the serviceDate to set
     */
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    /**
     * @return the serviceDescription
     */
    public String getServiceDescription() {
        return serviceDescription;
    }

    /**
     * @param serviceDescription the serviceDescription to set
     */
    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    /**
     * @return the ticketStatus
     */
    

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
     * @return the userdisplaydao
     */
    public UserDisplayDao getUserdisplaydao() {
        return userdisplaydao;
    }

    /**
     * @param userdisplaydao the userdisplaydao to set
     */
    public void setUserdisplaydao(UserDisplayDao userdisplaydao) {
        this.userdisplaydao = userdisplaydao;
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
     * @return the usdList
     */
    public List<UserDisplay> getUsdList() {
        return usdList;
    }

    /**
     * @param usdList the usdList to set
     */
    public void setUsdList(List<UserDisplay> usdList) {
        this.usdList = usdList;
    }

    /**
     * @return the ticketStatus
     */
    public String getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @param ticketStatus the ticketStatus to set
     */
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

}
