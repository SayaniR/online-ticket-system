package com.onlineticketing.core;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import com.onlineticketing.core.ConnectionManager;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prasun
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException,SQLException{
     Connection con= null;
     String q = "select * from admin where adminId = 1";
     con = ConnectionManager.getConnection();
     Statement statemnt1 = con.createStatement();
     ResultSet rs =null;
     rs = statemnt1.executeQuery(q);
     display(rs);
    }
    public static void display(ResultSet rs) throws SQLException{

   while(rs.next())
   {
    int adminId = rs.getInt("adminId");
    String adminPassword = rs.getString("adminPassword");
    String adminName = rs.getString("adminName");
    String adminEmail = rs.getString("adminEmail");
    
    System.out.println("adminId: "+adminId+ "\n" +"adminPassword: "+adminPassword +"\n"+"adminName: "+adminName +"\n" +"adminEmail: "+adminEmail);
   }
  
  }
}
