package com.indium.bankingapp.Model;//import Service.AccountService;
import com.indium.bankingapp.Model.Account;
import Service.*;
import com.indium.bankingapp.Model.Service.AccountServiceTreeMapImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //AccountService = new AccountService();
       // AccountServiceArrayListImplementation accountService = new AccountServiceArrayListImplementation();
       // AccountServiceLinkListImplementation accountService = new AccountServiceLinkListImplementation();
        // HashMapImplementation accountService = new HashMapImplementation();
        //HashSetImplementation accountService = new HashSetImplementation();
        AccountServiceTreeMapImplementation accountService = new AccountServiceTreeMapImplementation();

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
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.next();
                    accountService.createAccount(id, name, balance, type);

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
                    System.out.print("Enter New Balance: ");
                    double newBalance = scanner.nextDouble();
                    accountService.updateBalance(updateId, newBalance);
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
