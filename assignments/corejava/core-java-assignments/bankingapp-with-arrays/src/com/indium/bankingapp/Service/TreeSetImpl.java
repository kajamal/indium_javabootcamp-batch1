package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetImpl implements BankOper {
    private Set<Account> accountSet = new TreeSet<>();

    @Override
    public void createAccount(Account account) {
        accountSet.add(account);
        System.out.println("Account Created Successfully");
    }

    @Override
    public Account[] getAllAccounts() {
        return accountSet.toArray(new Account[0]);
    }

    @Override
    public Account getAccountById(int id) {
        for (Account account : accountSet) {
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
            System.out.println("Account balance updated");
        }
        else {
            System.out.println("Account not found");
        }
    }

    @Override
    public void deleteAccount(int id) {
        Account accountToRemove = null;
        for (Account account : accountSet) {
            if (account.getId() == id) {
                accountToRemove = account;
                break;
            }
        }

        if (accountToRemove != null) {
            accountSet.remove(accountToRemove);
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Account not found");
        }
    }
}
