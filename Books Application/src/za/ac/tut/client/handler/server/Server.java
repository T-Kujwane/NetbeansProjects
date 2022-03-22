/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.client.handler.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import za.ac.tut.client.handler.ClientHandler;
import za.ac.tut.client.handler.thread.Client;
import za.ac.tut.client.message.Message;

/**
 *
 * @author Thato Keith Kujwane
 */
public class Server extends ClientHandler{
    private final int PORT_NUMBER;
    private ServerSocket serverSocket;
    private final ExecutorService exec;
    private final LinkedList<Client> loggedInClients;
    private final Thread monitor;
    
    public Server(int port){
        super();
        PORT_NUMBER = port;
        exec = Executors.newFixedThreadPool(3);
        loggedInClients = new LinkedList<>();
        
        Runnable r = new Runnable(){
            @Override
            public void run(){
                while(isActive()){
                    String command = "shutdown_server";
                    if (messages.contains(new Message(0, command, -1)) || messages.contains(new Message(1, command, -1))
                            || messages.contains(new Message(2, command, -1)))
                    {
                        stop();
                    }
                }
            }
        };
        monitor = new Thread(r);
        
    }

    @Override
    public void run() {
        log(Thread.currentThread().getName() + " started server");
        int count = 0;
        monitor.start();
        try{
            serverSocket = new ServerSocket(PORT_NUMBER);
            while(isActive()){
                System.out.println("Server waiting for connection\n");
                Socket socket = serverSocket.accept();
                Client cl = new Client(socket, count++);
                loggedInClients.add(cl);
                exec.execute(cl);
                log(cl + " is connected.");
                if (loggedInClients.size() == 3){
                    count = 0;
                }
            }
            exec.shutdown();
        }catch(Exception ex){
            handleException(ex);
        }
        log("Server has finished running");
    }
    
    public static void main(String[] args) {
        Server sv = new Server(8080);
        Thread t1 = new Thread(sv, "Server");
        t1.start();
    }
}
