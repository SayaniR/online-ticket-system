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
import java.util.ArrayList;
import java.util.List;
import ots.test.beans.FeedbackUser;

/**
 *
 * @author Home
 */
public class FeedbackUserDao {
     public int addUserFeedback(int issueId, String userName, String userFeedback) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO feedbackuser VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            ps.setString(2, userName);
            ps.setString(3, userFeedback);
           

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
     
     public List showUserFeedback(int issueId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<FeedbackUser> ufList = new ArrayList<>();
        try {
            String sql = "SELECT userName, userFeedback FROM feedbackuser WHERE issueId=?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            rs = ps.executeQuery();
            System.out.println("sql "+ps);
            while (rs.next()) {

                FeedbackUser uf = new FeedbackUser();
                
                uf.setUserName(rs.getString("userName"));
                uf.setUserFeedback(rs.getString("userFeedback"));

                ufList.add(uf);
            }
            return ufList;
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
