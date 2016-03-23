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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eric
 */
public class serverMsgHndlr extends Thread {
    
    ArrayList<Socket> localClientList;
    int clientNo = 0;
    
    //should assign server with client list
    public serverMsgHndlr(ArrayList<Socket> inputList, int input)
    {

            //this should initialize the client with some content to ensure we don't get stuck

            localClientList = inputList;
            clientNo = input;
 
    }
    
    public void run()
    {
  
    }
}
