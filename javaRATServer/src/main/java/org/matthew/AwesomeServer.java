package org.matthew;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class AwesomeServer implements Runnable{


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            serverSocket.setSoTimeout(0);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    System.out.println("client said: " + in.readLine());
                }
                catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
