///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package ots.test.actions;
//
//import java.util.List;
//import javax.servlet.http.HttpSession;
//import org.apache.struts2.ServletActionContext;
//import ots.test.beans.Tickets;
//import ots.test.beans.Users;
//import ots.test.dao.AdminDao;
//
///**
// *
// * @author prasun
// */
//public class AdminDashboard {
//    private AdminDao admindao = new AdminDao();
//    private List<Users> techAssign = null;
//    private List<Users> csrList = null;
//    private List<Users> techList = null;
//    private List<Tickets> ticketsList = null;
//    private Users users = null;
//    private String msg = "";
//    
//    
//    
//     public String execute() throws Exception {
//        
//        HttpSession session = ServletActionContext.getRequest().getSession(false);
//        
//        if (session == null || session.getAttribute("username") == null) {
//            setMsg("You are not logged in. Please login first!! ");
//            return "login";
//        } else {
//            setUserList(new ArrayList<User>());
//            setUserList(admin.getAllCustomers());
//            setComplaintList(csr.complaintList());
//            setResolvedComplaint(csr.resolvedComplaintList());
//            setUnresolvedComplaint(csr.unResolvedComplaintList());
//            setRejectedComplaint(csr.rejectedComplaintList());
//            setDeptList(admin.getDeptComplaintsNum());
//            return "success";
//        }
//
//    }
//
//    /**
//     * @return the admindao
//     */
//    public AdminDao getAdmindao() {
//        return admindao;
//    }
//
//    /**
//     * @param admindao the admindao to set
//     */
//    public void setAdmindao(AdminDao admindao) {
//        this.admindao = admindao;
//    }
//
//    /**
//     * @return the techAssign
//     */
//    public List<Users> getTechAssign() {
//        return techAssign;
//    }
//
//    /**
//     * @param techAssign the techAssign to set
//     */
//    public void setTechAssign(List<Users> techAssign) {
//        this.techAssign = techAssign;
//    }
//
//    /**
//     * @return the csrList
//     */
//    public List<Users> getCsrList() {
//        return csrList;
//    }
//
//    /**
//     * @param csrList the csrList to set
//     */
//    public void setCsrList(List<Users> csrList) {
//        this.csrList = csrList;
//    }
//
//    /**
//     * @return the techList
//     */
//    public List<Users> getTechList() {
//        return techList;
//    }
//
//    /**
//     * @param techList the techList to set
//     */
//    public void setTechList(List<Users> techList) {
//        this.techList = techList;
//    }
//
//    /**
//     * @return the ticketsList
//     */
//    public List<Tickets> getTicketsList() {
//        return ticketsList;
//    }
//
//    /**
//     * @param ticketsList the ticketsList to set
//     */
//    public void setTicketsList(List<Tickets> ticketsList) {
//        this.ticketsList = ticketsList;
//    }
//
//    /**
//     * @return the users
//     */
//    public Users getUsers() {
//        return users;
//    }
//
//    /**
//     * @param users the users to set
//     */
//    public void setUsers(Users users) {
//        this.users = users;
//    }
//
//    /**
//     * @return the msg
//     */
//    public String getMsg() {
//        return msg;
//    }
//
//    /**
//     * @param msg the msg to set
//     */
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//    
//}
