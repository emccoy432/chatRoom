/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eric
 */
public class clientMsgHndlr extends Thread{
    
    ArrayList<Socket> localSocketList;
    int clientNo = 0;
    boolean stop = false;
    
    public clientMsgHndlr(ArrayList<Socket> inputList, int input)
    {
   //     System.out.println("Size b4 init" + localClientList.size());
        localSocketList = inputList;
        clientNo = input;
    }
    
    public void run()
    {
        Scanner in =  new  Scanner(System.in);
        try{
            
        System.out.println("Client: Just connected to " + localSocketList.get(clientNo).getRemoteSocketAddress());  
        
        OutputStream outToServer = localSocketList.get(clientNo).getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        System.out.println("Enter Message: ");

        String msg = in.nextLine();
    
        out.writeUTF(msg +" from " + localSocketList.get(clientNo).getLocalSocketAddress());
        InputStream inFromServer = localSocketList.get(clientNo).getInputStream();
        System.out.println("Waiting for  server input");
  //at this point it stalls because nothing has been written to the client object in the list referred  to by the Input stream method. 
  //the clientMsgHndlr and serverMsgHndlr both have seperate copies of the clientSocketList.  What we need to do is to make a central copy
  //of this list which is stored independantly of the threads and which the threads can modify.  
        
        DataInputStream inChat = new DataInputStream(inFromServer);

        System.out.println("Server says " + inChat.readUTF());

        Scanner cont = new Scanner(System.in);
        System.out.println("Do you wish to continue chatting? Y/N");
        String con = cont.nextLine();
      
        if(con.equalsIgnoreCase("Y"))
        {
            System.out.println("Lets bring her back around");
        }
        else if(!con.equalsIgnoreCase("Y"))
        {
            localSocketList.get(clientNo).close();
            stop = false;
            System.out.println("This is sloppy but we are waiting for the server to time out: have a nice day!");
        }
        
        }catch(IOException e)
        {
            e.printStackTrace();
        } 
    
    }
}
