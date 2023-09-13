package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;
import java.util.HashMap;

public class HashMapImplementation implements BankOper {
    private HashMap<Integer, Account> accountMap = new HashMap<>();
    private int accountIdCounter = 1;

    @Override
    public void createAccount(Account account) {
        accountMap.put(accountIdCounter, account);
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
    public void updateBalance(Account account, int newBalance) {
        if (account != null) {
            account.setBalance(newBalance);
            System.out.println("Account balance updated");
        }
        else {
            System.out.println("Account not found");
        }
    }

    @Override
    public void deleteAccount(int id) {
        accountMap.remove(id);
    }
}
