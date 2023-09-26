package com.indium.bankingapp;
//import Service.AccountService;
import com.indium.bankingapp.Model.Account;
import com.indium.bankingapp.Service.*;
//import com.indium.bankingapp.Service.AccountServiceLinkListImplementation;

//import com.indium.bankingapp.Service.AccountServiceArrImpl;
//import com.indium.bankingapp.Service.HashSetImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //AccountServiceArrayListImplementation accountService = new AccountServiceArrayListImplementation();
         //AccountServiceLinkListImplementation accountService = new AccountServiceLinkListImplementation();
       // HashMapImplementation accountService = new HashMapImplementation();
        //TreeSetImpl accountService = new TreeSetImpl();
        //AccountServiceTreeMapImplementation accountService = new AccountServiceTreeMapImplementation();
       HashSetImplementation accountService = new HashSetImplementation();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Account Management Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. View Account by ID");
            System.out.println("4. Update Account Balance");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter Account ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Account Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Balance: ");
                    int balance = scanner.nextInt();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.next();
                    Account newAccount = new Account(id, name, balance, type);
                    accountService.createAccount(newAccount);

                    break;
                case 2:

                    Account[] allAccounts = accountService.getAllAccounts();
                    for (Account account : allAccounts) {
                        System.out.println(account);
                        System.out.println();

                    }
                    break;
                case 3:

                    System.out.print("Enter Account ID to view: ");
                    int viewId = scanner.nextInt();
                    Account viewAccount = accountService.getAccountById(viewId);
                    if (viewAccount != null) {
                        System.out.println(viewAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Account ID to update balance: ");
                    int updateId = scanner.nextInt();
                    Account updateAccount = accountService.getAccountById(updateId);
                    if (updateAccount != null) {
                        System.out.print("Enter the new amount : ");
                        int newBalance = scanner.nextInt();
                        accountService.updateBalance(updateAccount, newBalance);
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;
                case 5:

                    System.out.print("Enter Account ID to delete: ");
                    int deleteId = scanner.nextInt();
                    accountService.deleteAccount(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
