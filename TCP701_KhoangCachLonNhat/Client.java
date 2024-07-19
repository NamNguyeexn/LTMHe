/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpkhoangcachnhonhat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author dinht
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket ClientSocket = new Socket("Localhost", 1234);

        System.out.println("Connected to server");

        DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream());

        DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream());

        String ma = "MaSV;MaCauhoi";

        outToServer.writeUTF(ma);

        String nhan = inFromServer.readUTF();
        List<Integer> a = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(nhan, ",");
        while (tokenizer.hasMoreTokens()) {
            a.add(Integer.parseInt(tokenizer.nextToken()));
            //System.out.println(a.get(a.size()-1));
        }
        
        String kq = "";
        int min = 9999;
        Collections.sort(a);
        for (int i = a.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int t = a.get(i)-a.get(j);
                if(a.contains(t) && t<min){
                    min=t;
                    kq = "";
                    kq += t + "," + a.get(j) + "," + a.get(i);
                }
            }
        }
        
        System.out.println(kq);
        outToServer.writeUTF(kq);
        
        
        //System.out.println(nhan);

        ClientSocket.close();
    }
}
