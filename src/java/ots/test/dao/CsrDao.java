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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ots.test.beans.Tickets;
import ots.test.beans.Users;
import ots.test.core.ConnectionManager;

/**
 *
 * @author prasun
 */
public class CsrDao {

    public int ticketLodge(int ticketId, String type, String equipmentType, String description, int assignedTo, Date assignedDate, int ticketStatusId, Date solvedDate) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        java.util.Date myDate = cal.getTime();
        //java.util.Date myDate = format.parse( "10/10/2009" ); 

        int i = 0;

        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO ticketsystem.tickets\n"
                    //+ "(ticketId,\n"
                    + "(type,\n"
                    + "equipmentType,\n"
                    + "description,\n"
                    + "assignedTo,\n"
                    + "assignedDate,\n"
                    + "ticketStatusId,\n"
                    + "solvedDate)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, ticketId);
            type="L1";
            ps.setString(1, type);
            ps.setString(2, equipmentType);
            ps.setString(3, description);
            ps.setInt(4, assignedTo);
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            ps.setDate(5, sqlDate);
            ticketStatusId=1;
            ps.setInt(6, ticketStatusId);
            cal.add(Calendar.DATE, 2);
            java.util.Date myDate2 = cal.getTime();
            java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime());
            ps.setDate(7, sqlDate2);
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

    public List<Tickets> getActiveTickets() throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Tickets> ticketsList = new ArrayList<>();
        try {
            String sql = "SELECT t.type,t.description,u.userFullName,t.assignedDate,ts.name\n"
                    + "FROM tickets t, users u, ticketstatus ts  where ticketStatusId  \n"
                    + "in(1,2,3) and t.assignedTo=u.userId and ts.id=t.ticketStatusId";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
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
