package com.zensar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        

        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:mysql:
        Connection conn = DriverManager.getConnection(url, "root", "root");

        
        String query = "select * from emp";
        Statement stmt = conn.createStatement();

        
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("================Employee Table Contents=====================");
        System.out.println("ID \t NAME");
        System.out.println("==============================================================");
        while(rs.next()) {
            System.out.println(rs.getInt("id")+"\t "+rs.getString("name")
            +rs.getString("salary")+rs.getString("commission")+rs.getString("role")
            +rs.getString("deptno"));
        }

        
        if (rs!=null)
            rs.close();
        if (stmt !=null)
            stmt.close();
        if(conn!=null)
            conn.close();
    }

}
