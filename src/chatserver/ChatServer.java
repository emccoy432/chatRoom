/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;

/**
 *
 * @author Eric
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port;
        port = 8675;
    try
    {
        Thread t = new Server(port);
        Thread c = new Client();
        t.start();
        c.start();
    }catch(IOException e)
   {
        e.printStackTrace();
   }
    

    
    }
}