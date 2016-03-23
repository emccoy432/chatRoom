/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

/**
 *
 * @author Eric
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server extends Thread {
    private ServerSocket serverSocket;
    boolean cont = false;
    int clientNo = 0;
    ArrayList<Socket> clientSocketList = new ArrayList<Socket>();
    
    public Server(int port, boolean input) throws IOException {
        serverSocket = new ServerSocket(port);
        cont = input;
     
        serverSocket.setSoTimeout(10000);
    }
    
    public void run()
    {
 
        while(cont)
        {
        try
        {
        System.out.println("Server starts");
        System.out.println("************************************************************************");
        System.out.println("Server: Waiting for client on port " + serverSocket.getLocalPort() + "...");
        Socket client = serverSocket.accept();
        
        Thread.yield();
        clientSocketList.add(client);
  
        System.out.println("Server: Just connected to " + clientSocketList.get(clientNo).getRemoteSocketAddress());
        
         clientMsgHndlr Chndlr = new clientMsgHndlr(clientSocketList, clientNo);
         serverMsgHndlr Shndlr = new serverMsgHndlr(clientSocketList, clientNo);
         Shndlr.start(); 
         Chndlr.start();
      
         clientNo++;
    
         /*
        clientNo++;
        clientSocketList.add(client);
        Thread serverMsgHndlr = new Thread();
        serverMsgHndlr.start();
        
        
        client.close();
             
        }catch(IOException e)
        {;
            e.printStackTrace();
            break;
        }  */
         cont = false;
    }       catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
}

}}