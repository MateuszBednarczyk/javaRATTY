package org.matthew;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String ip;
    static int port;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        configureIp(scanner);
        configurePort(scanner);
        System.out.println("CLIENT SIDE");
        AwesomeClient awesomeClient = new AwesomeClient(ip, port);
        awesomeClient.startCon();
        if (awesomeClient.getClientSocket().isBound()) {
            awesomeClient.stopCon();
            while (true) {
                printMenu();
                switch (scanner.nextInt()) {
                    case 1 -> awesomeClient.executeCommand();
                    case 2 -> System.exit(0);
                    default -> throw new RuntimeException("Bad input");
                }
            }
        }
    }

    static void printMenu() {
        System.out.println("1. Execute command");
        System.out.println("2. Exit");
    }

    static void configureIp(Scanner scanner) {
        System.out.println("Pass ip");
        ip = scanner.nextLine();
    }

    static void configurePort(Scanner scanner) {
        System.out.println("Pass port");
        port = scanner.nextInt();
    }

}