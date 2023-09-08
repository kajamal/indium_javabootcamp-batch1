package com.indium.bankingapp.Model.Service;

import com.indium.bankingapp.Model.Account;

public class AccountService implements BankOper {
    private Account[] accounts;
    private int numberOfAccounts;
    private static final int MAX_ACCOUNTS = 100;

    public AccountService() {
        accounts = new Account[MAX_ACCOUNTS];
        numberOfAccounts = 0;
    }

    @Override
    public void createAccount(int id, String name, double balance, String type) {
        if (numberOfAccounts < MAX_ACCOUNTS) {
            accounts[numberOfAccounts] = new Account(id, name, balance, type);
            numberOfAccounts++;
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Maximum number of accounts reached.");
        }
    }

    @Override
    public Account[] getAllAccounts() {
        Account[] allAccounts = new Account[numberOfAccounts];
        System.arraycopy(accounts, 0, allAccounts, 0, numberOfAccounts);
        return allAccounts;
    }

    @Override
    public Account getAccountById(int id) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getId() == id) {
                return accounts[i];
            }
        }
        return null;
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getId() == id) {
                accounts[i].setBalance(newBalance);
                System.out.println("Account balance updated successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    @Override
    public void deleteAccount(int id) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getId() == id) {
                for (int j = i; j < numberOfAccounts - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[numberOfAccounts - 1] = null;
                numberOfAccounts--;
                System.out.println("Account deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
