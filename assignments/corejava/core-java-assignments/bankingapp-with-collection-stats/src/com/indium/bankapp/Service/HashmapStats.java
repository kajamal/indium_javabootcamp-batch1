package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;

import java.util.*;
import java.util.stream.Collectors;

public class HashmapStats implements BankOperation {
    private HashMap<Integer, Account> accountMap = new HashMap<>();
    private int accountIdCounter = 1;

    @Override
    public void createAccount(Account account) {
        int id = accountIdCounter++;
        account.setId(id);
        accountMap.put(id, account);
        System.out.println("Account created successfully.");
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
                System.out.println("Account balance updated successfully.");
            } else {
                System.out.println("Account balance not updated");
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


