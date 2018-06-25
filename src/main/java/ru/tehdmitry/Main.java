package ru.tehdmitry;

public class Main {

    public static void main(String[] args) {
        Webserver webserver = new Webserver();

        try {
            webserver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
