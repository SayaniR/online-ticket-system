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
 * @author Prasun
 */
public class AdminDao {

    public Admin validateLoginCredentials(String adminEmail, String adminPassword) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        Admin admin = null;
        //admin.setValidAdmin(false);
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM admin WHERE adminEmail= ? and adminPassword= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("adminEmail= " + adminEmail);
            //we need to connect to database or other system and validate user with
            //this userName and password
            ps.setString(1, adminEmail);
            ps.setString(2, adminPassword);
            System.out.println("Got the connection.........................." + con);
            System.out.println("Select SQL = " + ps);
            rs = ps.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminPassword(rs.getString("adminPassword"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setAdminEmail(rs.getString("adminEmail"));
                admin.setValidAdmin(true);
                System.out.println(admin.isValidAdmin());
            }
            return admin;
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
