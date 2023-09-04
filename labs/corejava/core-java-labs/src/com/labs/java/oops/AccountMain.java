package com.labs.java.oops;

public class AccountMain {
        public static void main(String[] args) {



            Account acc = new Account();

            acc.id = 123;

            acc.name ="kaja";

            acc.type = "savings";

            acc.balance = 25000;

            acc.active = true;



            acc.openAccount();

            acc.deposit(10000);

            acc.withdraw(1000);

            System.out.println("current balance is "+acc.checkBalance());

            acc.closedAccount();



//            Account acc2 = new Account();
//
//            acc2.id = 6591;
//
//            acc2.name ="kaja";
//
//            acc2.type = "savings";
//
//            acc2.balance = 25000;
//
//            acc2.active = true;


//
//            acc2.openAccount();
//
//            acc2.deposit(10000);
//
//            acc2.withdraw(1000);
//
//            System.out.println("current balance is " +acc2.checkBalance());
//
//            acc2.closedAccount();

            Account acc3 = new Account(105 , "kaja","saving",10000,true);
            acc3.openAccount();
            acc3.withdraw(2000);
            acc3.deposit(5000);
            acc3.checkBalance();
            acc3.closedAccount();

            System.out.println(acc3.toString());


        }



    }


