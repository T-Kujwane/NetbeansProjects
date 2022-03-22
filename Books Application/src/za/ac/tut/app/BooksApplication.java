/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.app;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.Book;
import za.ac.tut.BookProcessor;

/**
 * This class is where our application will start
 * @author Thato Keith Kujwane
 */
public class BooksApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        ObjectOutputStream oos = null;
        try{
            String sep = File.separatorChar + "";
            File f = new File(System.getProperty("user.home") + sep + "Documents" + sep +"17_Feb_2022_newFile.siyakh");
            oos = new ObjectOutputStream(new FileOutputStream(f, true));
            //Creating random books
            Book firstBook = new Book("Discrete Mathematics and Applications 12th Edition Susana Epp", 700);
            Book secondBook = new Book("Introduction to Object Oriented Programming 1st Edition TK Kujwane", 300);
            write(oos, firstBook);
            write(oos,secondBook);
            //Instantiate book processor
            BookProcessor processor = new BookProcessor();
            //Determine cheapest book
            Book cheapBook = processor.determineCheapestBook(firstBook, secondBook);
            write(oos, cheapBook);
            //Display information
            System.out.println("The cheapest book has the title \"" + cheapBook.getTitle() + "\"" +
                    " and sells at R" + cheapBook.getPrice());
            //Increase book price by 50% of the cjeap book price
            //This is random since it was not specified in the question
            Book modifiedBook = processor.increaseBookPrice(cheapBook, (0.5) * cheapBook.getPrice());
            write(oos, modifiedBook);
            oos.close();
            //Display information
            System.out.println("The modified book costs: R" + modifiedBook.getPrice());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            try{
                Object readObject = read(ois,f);
                while(readObject != null){
                    if (readObject instanceof Book){
                        Book b = (Book) readObject;
                        System.out.println(b.getTitle() + " sold at R" + b.getPrice());
                    }
                    readObject = read(ois,f);
                }
            }catch(EOFException ex){
                System.out.println("Input stream finished reading");
            } catch (ClassNotFoundException | InterruptedException ex) {
                System.out.println("IOException Occured");
            }finally{
                System.out.println("Program terminated");
                ois.close();
        }
        }catch(IOException ex){
            Logger.getLogger(BooksApplication.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(BooksApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void write(ObjectOutputStream oos, Object writtenObject) throws IOException{
        oos.writeObject(writtenObject);
        oos.flush();
    }
    
    private static Object read(ObjectInputStream ois, File f) throws IOException, ClassNotFoundException, InterruptedException{
        Object obj = ois.readObject();
        System.out.println("Stream read " + obj);
        Thread.sleep(1_000);
        return obj;
    }
}
