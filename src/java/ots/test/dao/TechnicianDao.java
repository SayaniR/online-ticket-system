/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ots.test.actions.TechnicianAction;
import ots.test.beans.Tickets;
import ots.test.beans.Users;
import ots.test.core.ConnectionManager;

/**
 *
 * @author prasun
 */
public class TechnicianDao {

    public Tickets fetchTicketDetails(int ticketId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        Tickets tickets = new Tickets();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM ticketsystem.tickets WHERE ticketId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("assignedTo = " + ticketId);
            ps.setInt(1, ticketId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                tickets.setTicketId(rs.getInt("ticketId"));
                tickets.setType(rs.getString("type"));
                tickets.setEquipmentType(rs.getString("equipmentType"));
                tickets.setDescription(rs.getString("description"));
                tickets.setAssignedTo(rs.getInt("assignedTo"));
                tickets.setAssignedDate(rs.getDate("assignedDate"));
                tickets.setTicketStatusId(rs.getInt("ticketStatusId"));
                tickets.setSolvedDate(rs.getDate("solvedDate"));

            }
            return tickets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateTicketDetails(int ticketId, String type, String equipmentType, String description, int assignedTo, Date assignedDate, int ticketStatusId, Date solvedDate) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        Calendar cal = Calendar.getInstance();
        //cal.add( Calendar.DATE, 2 );
        int i = 0;
        try {
            String sql = "UPDATE ticketsystem.tickets SET type = ?, assignedTo = ?, ticketStatusId = ?, solvedDate=? WHERE ticketId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ps.setInt(2, assignedTo);
            ps.setInt(3, ticketStatusId);
            System.out.println("ticket type" + type);
            if ("L2".equals(type)) {
                cal.add(Calendar.DATE, 4);
                java.util.Date myDate3 = cal.getTime();
                java.sql.Date sqlDate3 = new java.sql.Date(myDate3.getTime());
                solvedDate = sqlDate3;
                System.out.println("solvedDate" + solvedDate);
                ps.setDate(4, solvedDate);
            } else if ("L3".equals(type)) {
                cal.add(Calendar.DATE, 6);
                java.util.Date myDate6 = cal.getTime();
                java.sql.Date sqlDate6 = new java.sql.Date(myDate6.getTime());
                solvedDate = sqlDate6;
                ps.setDate(4, solvedDate);
            }

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

    public List<Users> getActiveTech() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Users> techList = new ArrayList<>();
        try {
            String sql = "SELECT userId,userFullName FROM users where roleId=3 and statusId=1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserId(rs.getInt("userId"));
                users.setUserFullName(rs.getString("userFullName"));
                techList.add(users);
            }
            return techList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Tickets> getActiveTickets(String email) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Tickets> ticketsList = new ArrayList<>();
        try {
            String sql = "SELECT t.type,t.description,u.userFullName,t.assignedDate,ts.name\n"
                    + "FROM tickets t, users u, ticketstatus ts  where ticketStatusId  \n"
                    + "in(1,2,3) and t.assignedTo=u.userId and ts.id=t.ticketStatusId and u.email=?";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
            System.out.println("email "+email);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            System.out.println("ps" +ps);
            while (rs.next()) {
                Tickets tickets = new Tickets();
                //tickets.setTicketId(rs.getInt("tickteId"));
                tickets.setType(rs.getString("type"));
                tickets.setDescription(rs.getString("description"));
                tickets.setUserFullName(rs.getString("userFullName"));
                tickets.setAssignedDate(rs.getDate("assignedDate"));
                tickets.setName(rs.getString("name"));
                //tickets.setSolvedDate(rs.getDate("solvedDate"));
                ticketsList.add(tickets);
            }
            return ticketsList;
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
