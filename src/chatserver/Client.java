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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client extends Thread{
    String serverName = "localhost";
    int port = 8675;
    Socket client;
    boolean stop = true;
    Scanner cont = new Scanner(System.in);
  
  public void run()
  {
      while(stop)
      {
        try{
          
       //ideally the client merely makes the connection and then the server inputs the socket into the list.
        Scanner in = new Scanner(System.in);
        Thread.yield();
        System.out.println("Client starts");
        System.out.println("**********************************************************************");
        System.out.println("Client: Connecting to " + serverName + " on port " + port);
        client = new Socket(serverName, port);
  stop = false;
        //we need this initial message block to get the server going.
        
        
        }catch (IOException ex) {
              Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
          }
        //catch (InterruptedException ex) {
        //    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        //}
      }
  }
}
