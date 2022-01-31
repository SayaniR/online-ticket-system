/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.dao;

import com.onlineticketing.core.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import ots.test.beans.UserDisplay;

/**
 *
 * @author Home
 */
public class UserDisplayDao {

    public int enterUserDisplay(int issueId, Date serviceDate, String serviceDescription, String ticketStatus) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        java.util.Date myDate = cal.getTime();
        //java.util.Date myDate = format.parse( "10/10/2009" ); 

        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO ticketingsystem.userdisplay\n"
                    + "VALUES\n"
                    + "(?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            ps.setDate(2, sqlDate);
            ps.setString(3, serviceDescription);
            ps.setString(4, ticketStatus);

            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
     public List showUserDisplay(int issueId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<UserDisplay> usdList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ticketingsystem.userdisplay WHERE issueId=?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDisplay usd = new UserDisplay();
                usd.setIssueId(rs.getInt("issueId"));
                usd.setServiceDate(rs.getDate("serviceDate"));
                usd.setServiceDescription(rs.getString("serviceDescription"));
                usd.setTicketStatus(rs.getString("ticketStatus"));
               
                usdList.add(usd);
               
            }
            return usdList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


}
