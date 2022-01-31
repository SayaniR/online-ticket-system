/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ots.test.beans.CSR;
import com.onlineticketing.core.ConnectionManager;

/**
 *
 * @author Home
 */
public class CsrDao {
      public CSR csrLoginValidation(String csrEmail, String csrPassword) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        CSR csr =null;
        try {
             con = ConnectionManager.getConnection();
            System.out.println("Got the connection.........................." + con);
            String sql = "SELECT * FROM csr WHERE csrEmail= ? and csrPassword= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("email"+ csrEmail);
            ps.setString(1, csrEmail);
            System.out.println("password"+ csrPassword);
            ps.setString(2, csrPassword);

            rs = ps.executeQuery();

            if (rs.next()) {
                csr=new CSR();
                csr.setCsrId(rs.getInt("csrId"));
                csr.setCsrPassword(rs.getString("csrPassword"));
                csr.setCsrName(rs.getString("csrName"));
                csr.setCsrEmail(rs.getString("csrEmail"));
                csr.setValidCsr(true);

            } 
            return csr;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (con != null) {
        con.close();
            }

     
        }  
    
}

      
        public int addCsr(int csrId, String csrPassword, String csrName, String csrEmail) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO csr VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, csrId);
            ps.setString(2, csrPassword);
            ps.setString(3, csrName);
            ps.setString(4, csrEmail);
           

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
