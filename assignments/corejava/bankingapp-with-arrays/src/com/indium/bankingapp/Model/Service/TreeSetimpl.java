package com.indium.bankingapp.Model.Service;

import com.indium.bankingapp.Model.Account;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetimpl implements BankOper {
    private Set<Account> accountSet = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account account1, Account account2) {
            return Integer.compare(account1.getId(), account2.getId());
        }
    });

    @Override
    public void createAccount(int id, String name, double balance, String type) {
        Account newAccount = new Account(id, name, balance, type);
        accountSet.add(newAccount);
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
        return null; // Account not found
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        for (Account account : accountSet) {
            if (account.getId() == id) {
                account.setBalance(newBalance);
                return; // Exit the loop after updating
            }
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
