package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation implements BankOper {
    private Set<Account> accounts = new HashSet<>();

    @Override
    public void createAccount(int id, String name, double balance, String type) {

        Account newAccount = new Account(id, name, balance, type);

        accounts.add(newAccount);
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
    public void updateBalance(int id, double newBalance) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                account.setBalance(newBalance);
                break;
            }
        }
    }

    @Override
    public void deleteAccount(int id) {

        for (Account account : accounts) {
            if (account.getId() == id) {
                accounts.remove(account);
                break;
            }
        }
    }
}
