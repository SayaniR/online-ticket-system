/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.action;

import java.util.ArrayList;
import java.util.List;
import ots.test.beans.FeedbackTech;
import ots.test.dao.FeedbackTechDao;

/**
 *
 * @author Home
 */
public class FeedbackTechAction {

    private int issueId;
    private String techEmail;
    private String techfeedback;
    private String msg = "";
    private int ctr = 0;
    private boolean noData = false;
    private List<FeedbackTech> tfList = null;

    public String TechFeedback() {

        FeedbackTechDao ftd = new FeedbackTechDao();

        try {
            setCtr(ftd.addTechFeedback(getIssueId(), getTechEmail(), getTechfeedback()));
            if (getCtr() > 0) {
                setMsg("Thank you for your feedback!!");
            } else {
                setMsg("Please add feedback agan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TechFeedback";
    }

    public String showTechFeedback() {
        FeedbackTechDao ftd = new FeedbackTechDao();
        try {
            setTfList(new ArrayList<>());
            setTfList(ftd.showTechFeedback(getIssueId()));

            if (!tfList.isEmpty()) {
                setNoData(false);
                System.out.println("Feedback received from table = " + getTfList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "showfeedback";
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
     * @return the techName
     */
    

    /**
     * @return the techfeedback
     */
    public String getTechfeedback() {
        return techfeedback;
    }

    /**
     * @param techfeedback the techfeedback to set
     */
    public void setTechfeedback(String techfeedback) {
        this.techfeedback = techfeedback;
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
     * @return the tfList
     */
    public List<FeedbackTech> getTfList() {
        return tfList;
    }

    /**
     * @param tfList the tfList to set
     */
    public void setTfList(List<FeedbackTech> tfList) {
        this.tfList = tfList;
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
