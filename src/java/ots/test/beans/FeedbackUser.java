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
public class FeedbackUser {
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
