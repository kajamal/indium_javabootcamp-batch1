package com.indium.bankingapp.Model.Service;

import com.indium.bankingapp.Model.Account;
import java.util.HashMap;

public class HashMapImplementation implements BankOper {
    private HashMap<Integer, Account> accountMap = new HashMap<>();
    private int accountIdCounter = 1;

    @Override
    public void createAccount(int id,String name, double balance, String type) {
        Account newAccount = new Account(accountIdCounter, name, balance, type);
        accountMap.put(accountIdCounter, newAccount);
        System.out.println("Account created successfully.");
        accountIdCounter++;
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
    }
}
