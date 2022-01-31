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

/**
 *
 * @author a-cube
 */
public class TechDao {

    public  Tech validateLoginCredentials(String techEmail, String techPassword) throws SQLException {
        Connection con = null;
        Tech tech=null;
        try {
          
            con = ConnectionManager.getConnection();
            System.out.println("Got the connection.........................." + con);
            String sql = "SELECT * FROM tech WHERE techEmail= ? and techPassword= ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, techEmail);
            ps.setString(2, techPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tech=new Tech();
                tech.setTechName(rs.getString("techName"));
                tech.setTechEmail(rs.getString("techEmail"));
                tech.setTechPassword(rs.getString("techPassword"));
                tech.setTicketLevel(rs.getString("ticketLevel"));
                tech.setValidTech(true);
            } 
            return tech;

        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (con != null) {
                con.close();
            }

     
        }  
    
}

    public int addTech(String techName, String techEmail, String techPassword, String ticketLevel) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO tech "
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, techName);
            ps.setString(2, techEmail);
            ps.setString(3, techPassword);
            ps.setString(4, ticketLevel);

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

}
