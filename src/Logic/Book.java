/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Anushka Lakshan
 */
public class Book {
    
    // Class Properties
    private String ID;
    private String Name;
    private String Author;
    private String Description;
    private String Price;
    private String Quatity;
    private String Category;
    private String CategoryID;

   
    // Class methods
    public Book(String ID, String Name, String Author, String Description, String Price, String Quatity, String Category) {
        this.ID = ID;
        this.Name = Name;
        this.Author = Author;
        this.Description = Description;
        this.Price = Price;
        this.Quatity = Quatity;
        this.Category = Category;
    }

    public Book(String ID, String Name, String Author, String Description, String Price, String Quatity, String Category, String CategoryID) {
        this.ID = ID;
        this.Name = Name;
        this.Author = Author;
        this.Description = Description;
        this.Price = Price;
        this.Quatity = Quatity;
        this.Category = Category;
        this.CategoryID = CategoryID;
    }
    
   

    public String getID() {
        return ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getQuatity() {
        return Quatity;
    }

    public void setQuatity(String Quatity) {
        this.Quatity = Quatity;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    
    
}
