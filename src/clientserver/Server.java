/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author aakas
 */
public class Server {
        
    public static void main(String args[]) throws IOException {
        
        String clientmsg = null , msg; 
        System.out.println("************Welcome to the server************");
        ServerSocket s1 = new ServerSocket(1245);
        Socket s = s1.accept();
        System.out.println("Successfully Connected to the server");
        Scanner sc = new Scanner(s.getInputStream());
        Scanner sc1 = new Scanner(System.in);
        clientmsg = sc.nextLine();
        System.out.println(clientmsg);
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println("Hi,"+clientmsg);
        System.out.println("Hi,"+clientmsg);
        clientmsg = sc.nextLine();
        
        while(!("GOODBYE".equals(clientmsg))) {
            System.out.println(clientmsg);
            msg = sc1.nextLine();
            p.println(msg);
            clientmsg = sc.nextLine();
        }
        
        System.out.println(clientmsg);
        p.println("GOODBYE,HAVE A NICE DAY");
        System.out.println("GOODBYE,HAVE A NICE DAY");
            
    }
    
}
