/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anushka Lakshan
 */
public class Manager extends User{
    
    private String ID;
    private String Name;
    
    Connection conn;
    Statement st;
    
    public Manager(String Name, String userID, String Pass) {
        super(Name, userID, Pass);
        
        
    }
    
    public boolean AddBook(Book mybook, Connection conn){


        boolean status = false;
        
        
        String Bname = mybook.getName();
        String Bauth = mybook.getAuthor();
        String Bdesc = mybook.getDescription();
        String Bprice = mybook.getPrice();
        String Bquan = mybook.getQuatity();
        
        String newCat = mybook.getCategoryID();
        
        String sql = "INSERT INTO Book (Name, Author, Description, Price, Quatity, Cat_ID) VALUES (" +
        "'" + Bname + "', '" + Bauth + "', '" + Bdesc + "', '" + String.valueOf(Bprice) + "', '" +
        String.valueOf(Bquan) + "', '" + newCat + "')";

        try {
            st = conn.createStatement();

            int rowsInserted = st.executeUpdate(sql);

            // Check the number of rows affected
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Book Added Successfully", "Book added", JOptionPane.INFORMATION_MESSAGE);
                status = true;
            } else {
                JOptionPane.showMessageDialog(null, "Book adding failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Book adding failed: " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        } finally {
            
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {

            }
            
        }
        return status;
 
    }
    
    
    public void DeleteBook(String BookID, Connection conn){
        
        String sql = "DELETE FROM Book WHERE ID = '" + BookID + "'";
        
        try {
                st = conn.createStatement();

                int rowsAffected = st.executeUpdate(sql);

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Book Deleted Successfully", "Book Delete", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Book Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Book Delete failed : " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {

                }
            }
        
    }
    public boolean EditBook(Connection conn, Book mybook){
        
        boolean status = false;
        
        String BID = mybook.getID();
        String Bname = mybook.getName();
        String Bauth = mybook.getAuthor();
        String Bdesc = mybook.getDescription();
        String Bprice = mybook.getPrice();
        String Bquan = mybook.getQuatity();
        
        String newCat = mybook.getCategoryID();
        
        String sql = "UPDATE Book SET Name = '" + Bname + "', Author = '" + Bauth + "', Description = '" + Bdesc + "', Price = '" + Bprice + "', Quatity = '" + Bquan + "', Cat_ID = '" + newCat + "' WHERE ID = '" + BID + "'";

        try {
            Statement statement = conn.createStatement();

            int rowsUpdated = statement.executeUpdate(sql);

            // Check the number of rows affected
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Book Edited Successfully", "Book Edited", JOptionPane.INFORMATION_MESSAGE);
                status = true;
            } else {
                JOptionPane.showMessageDialog(null, "Book editing failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Book editing failed: " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Connection Close failed" + e.getMessage());
            }
            
        }
        return status;

        
    }
    
    public boolean AddCategory(Connection conn, String Name){
        String sql = "INSERT INTO Category (Name) VALUES ('" + Name + "')";
        
        boolean status = false;

        try {
            Statement st = conn.createStatement();

            int rowsInserted = st.executeUpdate(sql);

            // Check the number of rows affected
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Category Added Successfully", "Category added", JOptionPane.INFORMATION_MESSAGE);
                status = true;
            } else {
                JOptionPane.showMessageDialog(null, "Category adding failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Category adding failed: " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {

            }
        }
        
        return status;
    }
    public Boolean DeleteCategory(String ID,Connection conn){
        
            String sql = "DELETE FROM Category WHERE ID = '" + ID + "'";
            
            boolean status = false;

            try {
                st = conn.createStatement();

                int rowsAffected = st.executeUpdate(sql);

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Category Deleted Successfully", "Category Delete", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Category Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Category Delete failed : " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {

                }
            }
            
            return status;
        
        
    }
    public boolean EditCategory(String ID, String name, Connection conn){
        
        String sql = "UPDATE Category SET Name = '"+name+"' WHERE ID = '" + ID + "'";
            
            boolean status = false;

            try {
                st = conn.createStatement();

                int rowsAffected = st.executeUpdate(sql);

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Category Edited Successfully", "Category Edit", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Category Edited failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Category Edited failed : " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {

                }
            }
            
            return status;
    }
    
    public boolean AddAccount(String name, String Password, String isAdmin, Connection conn){
        
        HandleEncryption handleEncryption = new HandleEncryption();
        String encryptedPassword = handleEncryption.getEncryptedPass(Password);
        
        String sql = "INSERT INTO User (Name,Password,IsAdmin) VALUES ('" + name + "','" + encryptedPassword + "'," + isAdmin + ");";
        
        boolean status = false;

        try {
            Statement st = conn.createStatement();

            int rowsInserted = st.executeUpdate(sql);

            // Check the number of rows affected
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "user Added Successfully", "user added", JOptionPane.INFORMATION_MESSAGE);
                status = true;
            } else {
                JOptionPane.showMessageDialog(null, "user adding failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "user adding failed: " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {

            }
        }
        
        return status;
    }
    public boolean DeleteAccount(String id, Connection conn){
        String sql = "DELETE FROM User WHERE ID = '" + id + "'";
            
            boolean status = false;

            try {
                st = conn.createStatement();

                int rowsAffected = st.executeUpdate(sql);

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully", "Account Delete", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Account Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Account Delete failed : " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {

                }
            }
            
            return status;
    }
    public boolean ResetAccount(String newpass, Connection conn, String ID){
        
        HandleEncryption handleEncryption = new HandleEncryption();
        String encryptedPassword = handleEncryption.getEncryptedPass(newpass);
        
        String sql = "UPDATE User SET Password = '"+ encryptedPassword +"' WHERE ID = '" + ID + "'";
            
            boolean status = false;

            try {
                st = conn.createStatement();

                int rowsAffected = st.executeUpdate(sql);

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Password resetted Successfully", "Password reset", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Password reset  failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Password reset failed : " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {

                }
            }
            
            return status;
        
    }
}
