/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Anushka Lakshan
 */
public class Conn {
    Connection conn;

    public Conn() {
        try {
//            forClass.forClass("org.sqlite.jdbc");
//            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
            System.out.println("Connection successfull");
            
             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
            System.out.println("Failed : " + e.getMessage());
        }
    }
    
    public Connection getConn(){
        return conn;
    }
    public static void main(String[] args) {
        Conn now = new Conn();
    }
}


