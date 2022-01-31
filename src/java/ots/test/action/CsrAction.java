/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import ots.test.beans.CSR;
import ots.test.dao.AdminDao;
import ots.test.dao.CsrDao;

/**
 *
 * @author Home
 */
public class CsrAction extends ActionSupport{

    private int csrId;
    private String csrPassword;
    private String csrName;
    private String csrEmail;
    private boolean validCsr;
   private String msg = "";

    private String login = "";
    private CsrDao csrdao=null;
     
    private int ctr = 0;

    public String csrLogin() throws Exception {
        csrdao=new CsrDao();
        CSR csr = csrdao.csrLoginValidation(csrEmail, csrPassword);
        System.out.println("login Action "+ csr);
        if (csr != null) {
           csrId=csr.getCsrId();
           csrPassword=csr.getCsrPassword();
           csrName=csr.getCsrName();
           csrEmail=csr.getCsrEmail();
           Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("csrname", csr.getCsrName());
           login = "LoginCsr";
        } else {
                setMsg("Error");
                login = "FailureCsr";
            }
        return login;
    }

    public String logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("csrname");
// if (session.containsKey("adminname")) {
// session.remove("adminname");
// //login = "Failure";
// }
        System.out.println("csrname");
        return "LogoutCsr";
    }
    
    public String registerCsr() {

        CsrDao csr = new CsrDao();

        try {
            setCtr(csr.addCsr(getCsrId(), getCsrPassword(), getCsrName(), getCsrEmail()));
            if (getCtr() > 0) {
                setMsg("CSR Added");
            } else {
                setMsg("Unable to add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "RegisterCsr";
    }

    /**
     * @return the csrId
     */
    public int getCsrId() {
        return csrId;
    }

    /**
     * @param csrId the csrId to set
     */
    public void setCsrId(int csrId) {
        this.csrId = csrId;
    }

    /**
     * @return the csrPassword
     */
    public String getCsrPassword() {
        return csrPassword;
    }

    /**
     * @param csrPassword the csrPassword to set
     */
    public void setCsrPassword(String csrPassword) {
        this.csrPassword = csrPassword;
    }

    /**
     * @return the csrName
     */
    public String getCsrName() {
        return csrName;
    }

    /**
     * @param csrName the csrName to set
     */
    public void setCsrName(String csrName) {
        this.csrName = csrName;
    }

    /**
     * @return the csrEmail
     */
    public String getCsrEmail() {
        return csrEmail;
    }

    /**
     * @param csrEmail the csrEmail to set
     */
    public void setCsrEmail(String csrEmail) {
        this.csrEmail = csrEmail;
    }

    /**
     * @return the validCsr
     */
    public boolean isValidCsr() {
        return validCsr;
    }

    /**
     * @param validCsr the validCsr to set
     */
    public void setValidCsr(boolean validCsr) {
        this.validCsr = validCsr;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the csrdao
     */
    public CsrDao getCsrdao() {
        return csrdao;
    }

    /**
     * @param csrdao the csrdao to set
     */
    public void setCsrdao(CsrDao csrdao) {
        this.csrdao = csrdao;
    }

}
