/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this templat
 */
package Logic;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Anushka Lakshan
 */
public class Category {
    private String ID;
    private String Name;
    
    Connection conn;
    Statement st;

    public Category(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }
    public Category(String Name, Connection conn) {
        this.Name = Name;
        
        this.conn = conn;
        
        String sql = "SELECT * FROM Category WHERE Name = '"+Name+"';";
           
        try {

            
            st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
                
                
                
                this.ID = rs.getString("ID");
            }
            
            if(ID=="0"){
                JOptionPane.showMessageDialog(null, "Error from category");
            }
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error from category : " + e.getMessage());
        }

    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    
    
}
