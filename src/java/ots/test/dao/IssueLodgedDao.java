/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import com.onlineticketing.core.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ots.test.beans.IssueLodged;

/**
 *
 * @author prasun
 */
public class IssueLodgedDao {

    public int registerIssue(int issueId, String issueType, String issueDescription, String equipmentType, String ticketLevel, String techEmail, int ticketStatus, Date dateCaused, Date tentativeDates) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        java.util.Date myDate = cal.getTime();
        //java.util.Date myDate = format.parse( "10/10/2009" ); 

        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO ticketingsystem.issuelodged\n"
                    + "(issueId,\n"
                    + "issueType,\n"
                    + "issueDescription,\n"
                    + "equipmentType,\n"
                    + "ticketLevel,\n"
                    + "techEmail,\n"
                    + "ticketStatus, dateCaused, tentativeDates)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            ps.setString(2, issueType);
            ps.setString(3, issueDescription);
            ps.setString(4, equipmentType);
            ticketLevel="L1";
            ps.setString(5, ticketLevel);
            ps.setString(6, techEmail);
            ps.setInt(7, ticketStatus);
            //SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            ps.setDate(8, sqlDate);
            cal.add(Calendar.DATE, 2);
            java.util.Date myDate2 = cal.getTime();
            java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime());
            ps.setDate(9, sqlDate2);
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

    public IssueLodged fetchIssueDetails(int issueId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        IssueLodged issuelodged = new IssueLodged();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM ticketingsystem.issuelodged WHERE issueId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("issueId = " + issueId);
            ps.setInt(1, issueId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                issuelodged.setIssueId(rs.getInt("issueId"));
                issuelodged.setIssueType(rs.getString("issueType"));
                issuelodged.setIssueDescription(rs.getString("issueDescription"));
                issuelodged.setEquipmentType(rs.getString("equipmentType"));
                issuelodged.setTicketLevel(rs.getString("ticketLevel"));
                issuelodged.setTechEmail(rs.getString("techEmail"));
                issuelodged.setTicketStatus(rs.getInt("ticketStatus"));
                issuelodged.setDateCaused(rs.getDate("dateCaused"));
                issuelodged.setTentativeDates(rs.getDate("tentativeDates"));
            }
            return issuelodged;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateIssueDetails(int issueId, String issueType, String issueDescription, String equipmentType, String ticketLevel, String techEmail, int ticketStatus, Date dateCaused, Date tentativeDates) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        Calendar cal = Calendar.getInstance();
        //cal.add( Calendar.DATE, 2 );
        int i = 0;
        try {
            String sql = "UPDATE ticketingsystem.issuelodged SET ticketLevel = ?, techEmail = ?, ticketStatus = ?, tentativeDates=? WHERE issueId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ticketLevel);
            ps.setString(2, techEmail);
            ps.setInt(3, ticketStatus);
            System.out.println("ticket level"+ticketLevel);
            if ("L2".equals(ticketLevel)) {
                cal.add(Calendar.DATE, 4);
                java.util.Date myDate3 = cal.getTime();
                java.sql.Date sqlDate3 = new java.sql.Date(myDate3.getTime());
                tentativeDates = sqlDate3;
                System.out.println("tentative date"+tentativeDates);
                ps.setDate(4, tentativeDates);
            } else if ("L3".equals(ticketLevel)) {
                cal.add(Calendar.DATE, 6);
                java.util.Date myDate6 = cal.getTime();
                java.sql.Date sqlDate6 = new java.sql.Date(myDate6.getTime());
                tentativeDates = sqlDate6;
                ps.setDate(4, tentativeDates);
            }
            ps.setInt(5, issueId);

            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List show() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<IssueLodged> issueList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ticketingsystem.issuelodged";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                IssueLodged issuelodged = new IssueLodged();
                issuelodged.setIssueId(rs.getInt("issueId"));
                issuelodged.setIssueType(rs.getString("issueType"));
                issuelodged.setIssueDescription(rs.getString("issueDescription"));
                issuelodged.setEquipmentType(rs.getString("equipmentType"));
                issuelodged.setTicketLevel(rs.getString("ticketLevel"));
                issuelodged.setTechEmail(rs.getString("techEmail"));
                issuelodged.setTicketStatus(rs.getInt("ticketStatus"));
                issuelodged.setDateCaused(rs.getDate("dateCaused"));
                issuelodged.setTentativeDates(rs.getDate("tentativeDates"));
                issueList.add(issuelodged);

            }
            return issueList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List showTechIssues(String techEmail) throws SQLException, Exception {
        System.out.println("calling dao");
        ResultSet rs = null;
        Connection con = null;
        IssueLodged issuelodged = new IssueLodged();
        List<IssueLodged> issueListNew = new ArrayList<>();
        try {
            String sql = "SELECT issuelodged.issueId,issuelodged.techEmail, issuelodged.issueType,issuelodged.issueDescription,issuelodged.equipmentType,issuelodged.ticketLevel,\n"
                    + "issuelodged.ticketStatus,issuelodged.dateCaused,issuelodged.tentativeDates\n"
                    + " FROM issuelodged, tech\n"
                    + " WHERE issuelodged.techEmail = tech.techEmail and issuelodged.techEmail=?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("tech email "+ techEmail);
            ps.setString(1, techEmail);
            
            System.out.println("ps  ="+ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                //IssueLodged issuelodged = new IssueLodged();
                issuelodged.setIssueId(rs.getInt("issueId"));
                issuelodged.setTechEmail(rs.getString("techEmail"));
                issuelodged.setIssueType(rs.getString("issueType"));
                issuelodged.setIssueDescription(rs.getString("issueDescription"));
                issuelodged.setEquipmentType(rs.getString("equipmentType"));
                issuelodged.setTicketLevel(rs.getString("ticketLevel"));
                issuelodged.setTicketStatus(rs.getInt("ticketStatus"));
                issuelodged.setDateCaused(rs.getDate("dateCaused"));
                issuelodged.setTentativeDates(rs.getDate("tentativeDates"));
                issueListNew.add(issuelodged);

            }
            return issueListNew;
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
