package ru.demo;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Demo(), "demo");
        thread.start();
    }
}
