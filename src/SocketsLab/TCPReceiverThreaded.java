package SocketsLab;

import java.io.*;
import java.net.*;
class TCPReceiverThreaded {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4322);
            for (; ; ) {
                try {
                    final Socket client = ss.accept();
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                                PrintWriter out = new PrintWriter(client.getOutputStream());
                                String line;

                                out.println("ACK");
                                out.flush();

                                while ((line = in.readLine()) != null) {
                                    System.out.println(line + " received from " + client.getInetAddress());
                                    Thread.sleep(2000);

                                    out.println("ACK");
                                    out.flush();
                                    System.out.println("ACK");
                                }

                                client.close();
                            } catch (Exception e) {
                            }
                        }
                    }).start();
                } catch (Exception e) {
                    System.out.println("error " + e);
                }
            }
        } catch (Exception e) {
            {
                System.out.println("error " + e);
            }
        }
    }
}