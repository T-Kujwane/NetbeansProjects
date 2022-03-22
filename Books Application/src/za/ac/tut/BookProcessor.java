/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

/**
 * This class represents a book processor that determines the cheapest of two books
 * This book processor can also increment the price of a book by a given amount
 * @author Thato Keith Kujwane
 */
public class BookProcessor {
    //No instance variables are declared since our UML diagram does not specify any instance variables
    
    //This is the default constructor
    public BookProcessor(){
        
    }
    
    //This method will allow our application to determine the cheapest book of two book
    //This method must return a book (as specified in the UML diagram)
    public Book determineCheapestBook(Book firstBook, Book secondBook){
        //Get book prices
        double priceBook1 = firstBook.getPrice(), priceBook2 = secondBook.getPrice();
        Book cheapBook;
        
        //Compare prices
        if (priceBook1 < priceBook2){
            cheapBook = firstBook;
        }else {
            cheapBook = secondBook;
        }
        
        //Return cheapest book
        return cheapBook;
    }
    
    //This method increases the price of a given book by a given amount
    public Book increaseBookPrice(Book book, double amount){
        //Get the price of the current book
        double currentPrice = book.getPrice();
        
        //Increase the price
        double newPrice = currentPrice + amount;
        
        //Price could have been increased in one statement
        //book.setPrice(book.getPrice() + amount);
        //return new Book(book.getTitle(), book.getPrice());
        
        //Return modified book
        return new Book(book.getTitle(), newPrice);
        
        //This could also work
        //book.setPrice(newPrice);
        //return book;
    }
}
