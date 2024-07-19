/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpkhoangcachnhonhat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dinht
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);

        System.out.println("Server is now already");

        Socket connectionSocket = server.accept();
        
        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        
        String maNhan = inFromClient.readUTF();
        
        
        String chuoi = "1,3,9,19,33,20";
        outToClient.writeUTF(chuoi);
        
        
        String kq = inFromClient.readUTF();
        System.out.println(kq);
        
        connectionSocket.close();
        server.close();
        
    }
}
