/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.client.handler.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import za.ac.tut.client.handler.ClientHandler;
import za.ac.tut.client.message.Message;

/**
 *
 * @author Thato Keith Kujwane
 */
public class Client extends ClientHandler{
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private final Socket socket;
    private final int id;
    
    
    
    public Client(Socket s, int ID){
        super();
        socket = s;
        id = ID;
    }
    
    private void initializeIOStreams() throws IOException{
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }
    
    private void closeResources() throws IOException{
        oos.close();
        ois.close();
        socket.close();
    }
    
    private void writeToClient(Object obj) throws IOException{
        oos.writeObject(obj);
        oos.flush();
    }
    
    private Object readFromClient() throws IOException, ClassNotFoundException{
        return ois.readObject();
    }
    
    @Override
    public String toString() {
        return "Client " + id;
    }
    
    @Override
    public void run() {
        log(Thread.currentThread().getName() + " started " + this.toString());
        try {
            initializeIOStreams();
            log(this + " initialized IO streams.");
            
            while(isActive()){
                log(this.toString() + " is running");
                
                Object obj = readFromClient();
                if (obj instanceof String){
                    String s = (String) obj;
                    if (s.equalsIgnoreCase("check_inbox")){
                        synchronized(messages){
                            LinkedList<String> texts = new LinkedList<>();
                            for (Message message : messages) {
                                if (message.getDestinationID() == this.id){
                                    String info = "Client " + message.getAuthorID() + " says " + message.getText() + "to client " + id;
                                    texts.addLast(info);
                                    log(info);
                                    messages.remove(message);
                                }
                            }
                            writeToClient(texts);
                        }
                    }else {
                        stop();
                    }
                }else if (obj instanceof Message){
                    synchronized(messages){
                        Message m = (Message) obj;
                        messages.addLast(new Message(id, m.getText(), m.getDestinationID()));
                        log("Message added to queue");
                    }
                    writeToClient("message received");
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            handleException(ex);
        }finally{
            try {
                log(this + " is closing resources.");
                closeResources();
            } catch (Exception e) {
                handleException(e);
            }
        }
        log(this.toString() + " has finished.");
    }
    
    /*private Object sendMessage(Object obj) throws IOException, ClassNotFoundException{
        writeToClient(obj);
        return readFromClient();
    }*/
}
