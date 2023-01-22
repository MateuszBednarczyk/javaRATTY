package org.matthew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AwesomeClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner scanner = new Scanner(System.in);
    private String ip;
    private int port;

    public AwesomeClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startCon() throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void executeCommand() throws IOException {
        startCon();
        System.out.println("Type command to execute");
        String command = scanner.nextLine();
        out.println(command);
    }

    public void stopCon() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
