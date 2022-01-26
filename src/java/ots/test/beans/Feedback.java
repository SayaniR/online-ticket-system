/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.beans;

/**
 *
 * @author prasun
 */
public class Feedback {
    private int issueId;
     private String userName;
     private String userFeedback;

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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userFeedback
     */
    public String getUserFeedback() {
        return userFeedback;
    }

    /**
     * @param userFeedback the userFeedback to set
     */
    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }
    
}
