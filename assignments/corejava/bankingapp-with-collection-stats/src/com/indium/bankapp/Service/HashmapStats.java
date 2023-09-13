package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;

import java.util.*;
import java.util.stream.Collectors;

public class HashmapStats implements BankOperation {
    private HashMap<Integer, Account> accountMap = new HashMap<>();
    private int accountIdCounter = 1;

    @Override
    public void createAccount(int id, String name, int balance, String type) {
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
    public void updateBalance(int id, int newBalance) {
        Account account = accountMap.get(id);
        if (account != null) {
            account.setBalance(newBalance);
        }
    }

    @Override
    public void deleteAccount(int id) {
        accountMap.remove(id);
    }

    @Override
    public int countAccountsAboveOneLac() {
        int count = 0;
        for (Account account : accountMap.values()) {
            if (account.getBalance() > 100000) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<String, Integer> countAccountsByType() {
        Map<String, Integer> accountTypeCounts = new HashMap<>();
        for (Account account : accountMap.values()) {
            String accountType = account.getType();
            accountTypeCounts.put(accountType, accountTypeCounts.getOrDefault(accountType, 0) + 1);
        }
        return accountTypeCounts;
    }

    @Override
    public Map<String, Integer> countAndSortAccountsByType() {
        Map<String, Integer> accountTypeCounts = countAccountsByType();
        Map<String, Integer> sortedAccountTypeCounts = new TreeMap<>(accountTypeCounts);
        return sortedAccountTypeCounts;
    }

    public Map<String, Integer> calculateAvgBalanceByType() {
        return accountMap.values()
                .stream()
                .collect(Collectors.groupingBy(
                        Account::getType,
                        Collectors.averagingInt(Account::getBalance)
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()
                ));
    }
    @Override
    public List<Integer> getAccountIdsByName(String partialName) {
        List<Integer> accountIds = new ArrayList<>();
        for (Account account : accountMap.values()) {
            String accountName = account.getName();
            if (accountName.contains(partialName)) {
                accountIds.add(account.getId());
            }
        }
        return accountIds;
    }

}


