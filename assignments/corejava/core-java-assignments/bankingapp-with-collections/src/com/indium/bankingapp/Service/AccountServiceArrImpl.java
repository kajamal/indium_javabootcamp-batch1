package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

public class AccountServiceArrImpl implements BankOper {
    private static final int MAX_ACCOUNTS = 100;
    private Account[] accounts = new Account[MAX_ACCOUNTS];
    private int numberOfAccounts = 0;

    @Override
    public void createAccount(Account account) {
        if (numberOfAccounts < MAX_ACCOUNTS) {
            accounts[numberOfAccounts] = account;
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
    public void updateBalance(Account account, int newBalance) {
        if (account != null) {
            account.setBalance(newBalance);
            System.out.println("Account balance updated successfully.");
        } else {
            System.out.println("Account not found");
        }
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
                return; // Exit the loop once account is deleted
            }
        }
        System.out.println("Account not found.");
    }
}
