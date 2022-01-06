package com.example.kuis_1972004.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection (){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kuis2pbo2",
                    "root",
                    ""

            );
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}