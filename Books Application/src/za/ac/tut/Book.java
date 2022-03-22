/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.io.Serializable;

/**
 * This class represents a book that has a price and a title
 * @author Thato Keith Kujwane
 */
public class Book implements Serializable{
    //These are the instance variables defined in the UML diagram
    //Note the use of the private access modifier and the type (String and double) of these fields
    private String title;
    private double price;

    //This is the constructor for the book object
    //This constructor is also defined in the UML diagram
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    // These are your getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
