/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ots.test.beans.IssueLodged;
import ots.test.dao.IssueLodgedDao;

/**
 *
 * @author prasun
 */
public class IssueLodgedAction {

    private int issueId;
    private String issueType;
    private String issueDescription;
    private String equipmentType;
    private String ticketLevel;
    private String techEmail;
    private int ticketStatus;
    private Date dateCaused;
    private Date tentativeDates;
    private String msg = "";
    private int ctr = 0;
    private IssueLodgedDao issuelodgedao = null;
    private String submitType;
    private List<IssueLodged> issueList = new ArrayList<>();
    private List<IssueLodged> issueListNew = new ArrayList<>();
    private boolean noData = false;

    public String create() throws Exception {
        setIssuelodgedao(new IssueLodgedDao());

        try {
            setCtr(getIssuelodgedao().registerIssue(getIssueId(), getIssueType(), getIssueDescription(), getEquipmentType(), getTicketLevel(), getTechEmail(), getTicketStatus(), getDateCaused(), getTentativeDates()));
            if (getCtr() > 0) {
                setMsg("NEW TICKET GENERATED");
            } else {
                setMsg("SOMETHING WENT WRONG! TRY AGAIN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTERISSUE";
    }

    public String update() throws Exception {
        IssueLodgedDao issuelodgedao = new IssueLodgedDao();
        try {
            if (getSubmitType().equals("updatedata")) {
                IssueLodged issuelodged = issuelodgedao.fetchIssueDetails(getIssueId());
                if (issuelodged != null) {
                    setIssueId(issuelodged.getIssueId());
                    setIssueType(issuelodged.getIssueType());
                    setIssueDescription(issuelodged.getIssueDescription());
                    setEquipmentType(issuelodged.getEquipmentType());
                    setTicketLevel(issuelodged.getTicketLevel());
                    setTechEmail(issuelodged.getTechEmail());
                    setTicketStatus(issuelodged.getTicketStatus());
                    setDateCaused((Date) issuelodged.getDateCaused());
                    setTentativeDates((Date) issuelodged.getTentativeDates());
                }
            } else {
                int i = issuelodgedao.updateIssueDetails(getIssueId(), getIssueType(), getIssueDescription(), getEquipmentType(), getTicketLevel(), getTechEmail(), getTicketStatus(), getDateCaused(), getTentativeDates());
                if (i > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setMsg("error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATEISSUE";
    }

    public String show() throws Exception {
        IssueLodgedDao issuelodgeddao = new IssueLodgedDao();
        try {
            setIssueList(new ArrayList<>());
            setIssueList(issuelodgeddao.show());
            if (!issueList.isEmpty()) {
                setNoData(false);
                System.out.println("Issue retrieve = " + getIssueList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SHOWISSUE";
    }

    
    public String showToTech() throws Exception {
        System.out.println("calling show to tech");
        IssueLodgedDao issuelodgeddao = new IssueLodgedDao();
        try {
            setIssueListNew(new ArrayList<>());
            setIssueListNew(issuelodgeddao.showTechIssues(getTechEmail()));
            if (issueListNew != null) {
                setNoData(false);
                System.out.println("Issue retrieve = " + getIssueListNew().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SHOWISSUETOTECH";
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
     * @return the issueType
     */
    public String getIssueType() {
        return issueType;
    }

    /**
     * @param issueType the issueType to set
     */
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    /**
     * @return the issueDescription
     */
    public String getIssueDescription() {
        return issueDescription;
    }

    /**
     * @param issueDescription the issueDescription to set
     */
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
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

    /**
     * @return the techName
     */
    /**
     * @return the ticketStatus
     */
    public int getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @param ticketStatus the ticketStatus to set
     */
    public void setTicketStatus(int ticketStatus) {
        this.ticketStatus = ticketStatus;
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
     * @return the issuelodgedao
     */
    public IssueLodgedDao getIssuelodgedao() {
        return issuelodgedao;
    }

    /**
     * @param issuelodgedao the issuelodgedao to set
     */
    public void setIssuelodgedao(IssueLodgedDao issuelodgedao) {
        this.issuelodgedao = issuelodgedao;
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
     * @return the issueList
     */
    public List<IssueLodged> getIssueList() {
        return issueList;
    }

    /**
     * @param issueList the issueList to set
     */
    public void setIssueList(List<IssueLodged> issueList) {
        this.issueList = issueList;
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
     * @return the dateCaused
     */
    public Date getDateCaused() {
        return dateCaused;
    }

    /**
     * @param dateCaused the dateCaused to set
     */
    public void setDateCaused(Date dateCaused) {
        this.dateCaused = dateCaused;
    }

    /**
     * @return the tentativeDates
     */
    public Date getTentativeDates() {
        return tentativeDates;
    }

    /**
     * @param tentativeDates the tentativeDates to set
     */
    public void setTentativeDates(Date tentativeDates) {
        this.tentativeDates = tentativeDates;
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
     * @return the issueListNew
     */
    public List<IssueLodged> getIssueListNew() {
        return issueListNew;
    }

    /**
     * @param issueListNew the issueListNew to set
     */
    public void setIssueListNew(List<IssueLodged> issueListNew) {
        this.issueListNew = issueListNew;
    }

}
