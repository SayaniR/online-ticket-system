/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.beans;

import java.util.Date;

/**
 *
 * @author Home
 */
public class IssueLodged {

    private int issueId;
    private String issueType;
    private String issueDescription;
    private String equipmentType;
    private String ticketLevel;
    private String techEmail;
    private int ticketStatus;
    private Date dateCaused;
    private Date tentativeDates;

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

}
