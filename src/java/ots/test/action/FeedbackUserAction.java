/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.action;

import java.util.ArrayList;
import java.util.List;
import ots.test.beans.FeedbackUser;
import ots.test.dao.FeedbackUserDao;

/**
 *
 * @author Home
 */
public class FeedbackUserAction {

    private int issueId;
    private String userName;
    private String userFeedback;
    private String msg = "";
    private int ctr = 0;
     private boolean noData = false;
    private List<FeedbackUser> ufList = null;
    
     public String TechFeedback() {

        FeedbackUserDao fud = new FeedbackUserDao();

        try {
            setCtr(fud.addUserFeedback(getIssueId(), getUserName(), getUserFeedback()));
            if (getCtr() > 0) {
                setMsg("Thank you for your feedback!!");
            } else {
                setMsg("Please add feedback again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UserFeedback";
    }
     
         public String showUserFeedback() {
        FeedbackUserDao fud = new FeedbackUserDao();
        try {
            setUfList(new ArrayList<>());
            setUfList(fud.showUserFeedback(getIssueId()));

            if (!ufList.isEmpty()) {
                setNoData(false);
                System.out.println("Feedback received from table = " + getUfList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "showuserFeedback";
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
     * @return the ufList
     */
    public List<FeedbackUser> getUfList() {
        return ufList;
    }

    /**
     * @param ufList the ufList to set
     */
    public void setUfList(List<FeedbackUser> ufList) {
        this.ufList = ufList;
    }

}
