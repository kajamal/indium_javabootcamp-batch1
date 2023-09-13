package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

import java.util.Map;
import java.util.TreeMap;

public class AccountServiceTreeMapImplementation implements BankOper {
    private Map<Integer, Account> accountMap = new TreeMap<>();

    @Override
    public void createAccount(Account account) {
        accountMap.put(account.getId(),account);
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
    public void updateBalance(Account account, int newBalance) {
        if (account != null) {
            account.setBalance(newBalance);
            System.out.println("Account balance updated successfully");
        } else {
            System.out.println("Account not found");
        }
    }

    @Override
    public void deleteAccount(int id) {
        Account removedAccount = accountMap.remove(id);
        if (removedAccount != null) {
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Account not found");
        }
    }
}
