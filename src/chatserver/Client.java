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
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client extends Thread{
    String serverName = "localhost";
    int port = 8675;
    Socket client;
  
  public void run()
  {
      while(true)
      {
        try{
        Thread.sleep(1000);
        System.out.println("Client starts");
        System.out.println("**********************************************************************");
        System.out.println("Client: Connecting to " + serverName + " on port " + port);
        client = new Socket(serverName, port);
        System.out.println("Client: Just connected to " + client.getRemoteSocketAddress());
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF("Hello from " + client.getLocalSocketAddress());
        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println("Server says " + in.readUTF());
        client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
  }
}
