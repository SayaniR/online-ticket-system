/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import ots.test.beans.Tech;
import com.onlineticketing.core.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a-cube
 */
public class Techdao {
    public int addTech(String techName, String techEmail, String techPassword, String ticketLevel) throws SQLException {
        int i = 0;
        Connection con = null;
        con = ConnectionManager.getConnection();
        String sql = "INSERT INTO \n"                    //Query likhna hai
                + "(techName,\n"
                + "techEmail,\n"
                + "techPassword,\n"
                + "ticketLevel)\n"
                + "VALUES\n"
                + "(?,?,?,?);";                                   
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, techName);
        ps.setString(2, techEmail);
        ps.setString(3, techPassword);
        ps.setString(4, ticketLevel);
        i = ps.executeUpdate();
        return i;
    }

 

public List techList() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Tech> techList = new ArrayList<>();
        try {
            String sql = "SELECT techId, techName, techEmail, techPassword,ticketLevel FROM tech;";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Tech tech = new Tech();
                tech.setTechId(rs.getInt("techId"));
                tech.setTechName(rs.getString("techName"));
                tech.setTechEmail(rs.getString("techEmail"));
                tech.setTechPassword(rs.getString("techPassword"));
                tech.setTicketLevel(rs.getString("ticketLevel"));
                

                techList.add(tech);
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

    public Tech fetchTechDetails(int techId) throws SQLException {
        Tech tech = new Tech();
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT tech.techId,\n"
                    + "    tech.techName,\n"
                    + "    tech.techEmail,\n"
                    + "    tech.techPassword,\n"
                    + "    tech.ticketLevel\n"
                    + "FROM  where techId=?;";              //location add krna hai
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("techId = " + techId);
            ps.setInt(1, techId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                tech.setTechId(rs.getInt("techId"));
                tech.setTechName(rs.getString("techName"));
                tech.setTechEmail(rs.getString("techEmail"));
                tech.setTechPassword(rs.getString("techPassword"));
                tech.setTicketLevel(rs.getString("ticketLevel"));

            }
            return tech;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateTechDetails(int techId, String techName, String techEmail, 
            String techPassword, String ticketLevel) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE \n"                //query update krna hai
                    + "SET\n"
                    + "techName = ?,\n"
                    + "techEmail = ?,\n"
                    + "techPassword = ?,\n"
                    + "ticketLevel = ?\n"
                    + "WHERE techId = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, techName);
            ps.setString(2, techEmail);
            ps.setString(3, techPassword);
            ps.setString(4, ticketLevel);
            ps.setInt(5, techId);
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
    
}
