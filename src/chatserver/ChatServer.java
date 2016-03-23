/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.util.Scanner;

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
        boolean cont = false;
        Scanner scan = new Scanner(System.in);
    try
    {
        System.out.println("Procceed with Chat (Y/N)");
        String choice = scan.nextLine();
        if(!choice.equals("Y"))
        {
            cont = false;
        }
        else
        {
            cont = true;
        }
        if(cont == true)
        {
        
            Thread s = new Server(port, cont);
            Thread c = new Client();
            s.start();
            c.start();
        }
        
    }catch(IOException e)
   {
        e.printStackTrace();
   }
    

    
    }
}