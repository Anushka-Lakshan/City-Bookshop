/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Anushka Lakshan
 */

// Abstraction concept
public abstract class User {
    private String Name;
    private String userID;
    private String passWord;
    
    public User(String Name, String userID, String passWord) {
        this.Name = Name;
        this.userID = userID;
        this.passWord = passWord;
    }

    public String getName() {
        return Name;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }


}
