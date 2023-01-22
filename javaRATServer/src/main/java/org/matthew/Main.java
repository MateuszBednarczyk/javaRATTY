package org.matthew;

public class Main {
    public static void main(String[] args) {
        System.out.println("RAT");;
        Thread thread = new Thread(new AwesomeServer());
        thread.start();
    }
}