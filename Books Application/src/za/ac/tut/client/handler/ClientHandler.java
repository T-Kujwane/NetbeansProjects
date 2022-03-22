/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.client.handler;

import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import za.ac.tut.client.message.Message;

/**
 *
 * @author Thato Keith Kujwane
 */
public abstract class ClientHandler implements Runnable{
    private volatile boolean isActive;
    protected final LinkedList<Message> messages = new LinkedList<>();;
    
    protected ClientHandler(){
        isActive = true;
        //messages = new LinkedList<>();
    }
    
    protected void display(String text, String title, int messageType){
        JOptionPane.showMessageDialog(null, text, title, messageType);
    }
    
    protected void log(String info){
        System.out.println(info + "\n");
    }
    
    protected void handleException(Exception ex){
        log(ex.toString());
        display(ex.getMessage(),"Something Went Wrong!" , JOptionPane.ERROR_MESSAGE);
        System.err.println("Exception thrown at " + new Date());
        ex.printStackTrace(System.err);
        System.err.println("\n");
    }
    
    protected void stop(){
        isActive = false;
    }
    
    protected boolean isActive(){
        return isActive;
    }
}
