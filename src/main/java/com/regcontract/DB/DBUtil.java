package com.regcontract.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by kabanaus on 27.02.2017.
 */
public class DBUtil {
    private static Connection conn = null;
    private static final String URL = "jdbc:postgresql://localhost/Contracts";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Qq123456";

    public static Connection getConnection() throws Exception{
        if (conn != null)
            return conn;
        else{
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        }
    }
}
