/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.beans;

/**
 *
 * @author Home
 */
public class TechResponse {

    private String equipmentType;
    private String issueType;
    private int ticketId;
    private String issueDescription;
    private String techSolution;

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
     * @return the techSolution
     */
    public String getTechSolution() {
        return techSolution;
    }

    /**
     * @param techSolution the techSolution to set
     */
    public void setTechSolution(String techSolution) {
        this.techSolution = techSolution;
    }

}
