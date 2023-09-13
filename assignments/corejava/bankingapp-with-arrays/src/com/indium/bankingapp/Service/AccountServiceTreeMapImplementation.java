package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

import java.util.Map;
import java.util.TreeMap;

public class AccountServiceTreeMapImplementation implements BankOper {
    private Map<Integer, Account> accountMap = new TreeMap<>();

    @Override
    public void createAccount(int id, String name, double balance, String type) {
        Account newAccount = new Account(id, name, balance, type);
        accountMap.put(id, newAccount);
        System.out.println("Account Created Successfully");
    }

    @Override
    public Account[] getAllAccounts() {
        return accountMap.values().toArray(new Account[0]);
    }

    @Override
    public Account getAccountById(int id) {
        return accountMap.get(id);
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        Account account = accountMap.get(id);
        if (account != null) {
            account.setBalance(newBalance);
        }
    }

    @Override
    public void deleteAccount(int id) {
        accountMap.remove(id);
        System.out.println("Account deleted successfully");
    }
}
