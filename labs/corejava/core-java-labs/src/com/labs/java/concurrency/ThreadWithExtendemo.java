package com.labs.java.concurrency;

public class ThreadWithExtendemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("enter into "+Thread.currentThread().getId() );
        CustomThread t = new CustomThread();

        t.setName("th");
        t.start();
        CustomThread t1 = new CustomThread();
        t1.setName("thread");
        t1.start();
        Thread.sleep(5*16);

    }
}
