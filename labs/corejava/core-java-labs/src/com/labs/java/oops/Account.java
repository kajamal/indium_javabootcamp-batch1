package com.labs.java.oops;

public class Account {
    int id;
    String name;
    String type;
    double balance;
    boolean active;

    public Account(){
        System.out.println("default constructor");
    }

    public Account(int id , String name ,String type, double balance, boolean active){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.active = active;

    }
    void openAccount() {
        System.out.println("account opened");
    }
    void closedAccount() {
        System.out.println("account closed");

    }
    void deposit(double amount) {

        this.balance += amount;

    }
    void withdraw(double amount) {

        this.balance -= amount;

    }
    double checkBalance() {
     return balance;

    }

    public boolean equals(Object obj) {

        if(obj instanceof Account) {

            return this.id == ((Account)obj).id;

        }

        return false;

    }

    public String toString(){
        return "Account id" + this.id+  "Account name" + this.name + "Acoount TYPE"+this.type+"Account balance" +this.balance;
    }
}
