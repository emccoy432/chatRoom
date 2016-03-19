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
public class Server extends Thread {
    private ServerSocket serverSocket;
    boolean cont = false;
    public Server(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }
    
    public void run()
    {
        Scanner scan = new Scanner(System.in);
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
        while(cont)
        {
        try
        {
        System.out.println("Server starts");
        System.out.println("************************************************************************");
        System.out.println("Server: Waiting for client on port " + serverSocket.getLocalPort() + "...");
        Socket client = serverSocket.accept();
        System.out.println("Server: Just connected to " + client.getRemoteSocketAddress());
        OutputStream outToClient = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToClient);
        System.out.println("Enter Message: ");
        String msg = scan.nextLine();
        out.writeUTF(msg);
        InputStream inFromClient = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromClient);
        System.out.println("Server: Client says " + in.readUTF());
        client.close();
             
        }catch(IOException e)
        {
            e.printStackTrace();
            break;
        }  
    }
}

}