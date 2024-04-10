package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("starting main thread");
        Thread thread = new Thread1();
        thread.setDaemon(true);
         thread.start();

         Thread thread2 = new Thread(new Thread2());
         thread2.start();
        System.out.println("ending main thread");
    }
}