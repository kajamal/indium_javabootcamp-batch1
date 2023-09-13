package com.labs.java.concurrency;

public class CoutomerRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Entered into " + Thread.currentThread().getName());
        System.out.println("********************");
        System.out.println("Exited from " + Thread.currentThread().getName());
    }
}
