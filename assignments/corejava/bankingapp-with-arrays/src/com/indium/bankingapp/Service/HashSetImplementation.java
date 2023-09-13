package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation implements BankOper {
    private Set<Account> accounts = new HashSet<>();

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
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
                System.out.println("Account balance updated successfully");
            } else {
                System.out.println("Account not found");
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
