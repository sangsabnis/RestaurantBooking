/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Sangram
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/egenrestaurant?zeroDateTimeBehavior=convertToNull";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading JDBC Driver");
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            System.err.println("Error getting connection");
            e.printStackTrace();
        }

        return con;
    }
//        public static void main(String[] args){
//            DBUtil db = new DBUtil();
//        }
}
