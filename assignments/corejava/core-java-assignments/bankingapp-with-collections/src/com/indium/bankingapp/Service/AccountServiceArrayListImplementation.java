package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;


import java.util.ArrayList;
import java.util.Iterator;

public class AccountServiceArrayListImplementation implements BankOper {

    private ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    @Override
    public Account[] getAllAccounts() {
        return accounts.toArray(new Account[0]);
    }

    @Override
    public Account getAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void updateBalance(Account account, int newBalance) {
            if (account != null) {
                account.setBalance(newBalance);
                System.out.println("Account balance updated successfully.");
            }else
        System.out.println("Account not found.");
        }


    @Override
    public void deleteAccount(int id) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getId() == id) {
                iterator.remove();
                System.out.println("Account deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
