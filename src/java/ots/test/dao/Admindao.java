/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import com.onlineticketing.core.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ots.test.beans.Admin;

/**
 *
 * @author prasun
 */
public class Admindao {
    public static Admin validateLoginCredentials(Admin admin) {
        Connection con = null;
        try {
            boolean valid = true;

            String userName = admin.getAdminEmail();
            String password = admin.getAdminPassword();
            //we need to connect to database or other system and validate user with
            //this userName and password
            con = ConnectionManager.getConnection();
            System.out.println("Got the connection.........................." + con);
            String sql = "SELECT adminId, adminPassword, adminName, adminEmail FROM admin"
                        + " where adminEmail=? and password=?;";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminId(rs.getInt("adminPassword"));
                admin.setAdminId(rs.getInt("adminName"));
                admin.setAdminId(rs.getInt("adminEmail"));
                admin.setValidAdmin(valid);
            } else {
                valid = false;
                admin.setValidAdmin(valid);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    //report the error in a log file
                }
            }
        }
        return admin;
    }
    
}
