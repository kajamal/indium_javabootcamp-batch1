package com.labs.java.concurrency;

public class ThreadSynchronizationdemo1 {

    public static void main(String[] args) {
        System.out.println("Entered into - "+Thread.currentThread().getName());
        SequenceGenerator seqGen = new SequenceGenerator();
        seqGen.increment();
        seqGen.decrement();
        seqGen.increment();
        System.out.println(seqGen.getSeqid());
        System.out.println("Exited from - "+Thread.currentThread().getName());
    }
}

class SequenceThread extends Thread{
    public void run(){
        System.out.println("Entered into - "+Thread.currentThread().getName());
        SequenceGenerator seqGen = new SequenceGenerator();
        seqGen.increment();
        seqGen.decrement();
        seqGen.increment();
        System.out.println(Thread.currentThread().getName()+" - "+seqGen.getSeqid()+" - "+SequenceGenerator.getSeqid());
        System.out.println("Exited from - "+Thread.currentThread().getName());
    }
}

class SequenceGenerator{
    public static int counter;

    public int seqId;
    public synchronized void increment(){
        seqId +=1;
        counter+=1;
    }

    public void decrement(){
        synchronized (this){
            seqId -=1;
            counter+=1;
        }
        System.out.println("incremented...");

    }

    public static int getSeqid() {
        return 0;
    }

//    public static int getSeqid() {
//        return Seqid;
//    }
}
