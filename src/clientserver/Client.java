/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

/**
 *
 * @author aakas
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String servermsg = null,msg;
        
        
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1",1245);
        System.out.println("Connecting to the Server.....");
        Scanner sc1 = new Scanner(s.getInputStream());
        PrintStream p = new PrintStream(s.getOutputStream());
        System.out.println("Enter your name:");
        msg = sc.nextLine();
        p.println(msg);
        
        while(!("GOODBYE".equals(msg))){   
        servermsg = sc1.nextLine();
        System.out.println(servermsg);
        msg = sc.nextLine();
        p.println(msg);
        }
        
        servermsg = sc1.nextLine();
        System.out.println(servermsg);
        
    }
    
}
