/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.beans;

/**
 *
 * @author prasun
 */
public class UserDisplay {
    private int issueId;
    private String serviceDate;
    private String serviceDescription;
    private int ticketStatus;

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
    public String getServiceDate() {
        return serviceDate;
    }

    /**
     * @param serviceDate the serviceDate to set
     */
    public void setServiceDate(String serviceDate) {
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
    public int getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @param ticketStatus the ticketStatus to set
     */
    public void setTicketStatus(int ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
