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
import ots.test.beans.FeedbackTech;

/**
 *
 * @author Home
 */
public class FeedbackTechDao {

    public int addTechFeedback(int issueId,String techEmail, String techfeedback) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO feedbacktech(issueId, techEmail, techfeedback) VALUES (?,?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            ps.setString(2, techEmail);
            ps.setString(3, techfeedback);

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

    public List showTechFeedback(int issueId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<FeedbackTech> tfList = new ArrayList<>();
        try {
            String sql = "SELECT techEmail, techfeedback FROM feedbacktech WHERE issueId=?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, issueId);
            rs = ps.executeQuery();
            while (rs.next()) {

                FeedbackTech tf = new FeedbackTech();

                tf.setTechEmail(rs.getString("techEmail"));
                tf.setTechfeedback(rs.getString("techfeedback"));

                tfList.add(tf);
            }
            return tfList;
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
