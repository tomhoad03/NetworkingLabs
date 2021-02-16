package SocketsLab;

import java.io.*;
import java.net.*;

class TCPSender {
    public static void main(String [] args) {
        try {
            Socket socket = new Socket("Tom-Desktop",4322);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for(int i=0;i<25;i++) {
                if (in.readLine().equals("ACK")) {
                    System.out.println("Acknowledged");
                    out.println("TCP message " + i);
                    out.flush();
                    System.out.println("TCP message "+ i +" sent");
                    Thread.sleep(1000);
                }
            }
        }
        catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}