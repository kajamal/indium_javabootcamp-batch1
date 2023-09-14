package com.indium.bankingapp.Service;


import com.indium.bankingapp.Model.Account;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AccountServiceHashMapImplement implements AccountService {
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
    public Map<Integer, String> getAccountIdsByName(String partialName) {
        Map<Integer,String> accountIds = new HashMap<>();
        for (Account account : accountMap.values()) {
            String accountName = account.getName();
            if (accountName.contains(partialName)) {
                accountIds.put(account.getId(), account.getName());
            }

        }

        return accountIds;

    }
    @Override
    public void importProducts() {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("./input/import.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int balance = Integer.parseInt(parts[2].trim());
                String type = parts[3].trim();
                Account account = new Account(id,name,balance,type);
                accountMap.put(balance, account);
                count++;

            }
            System.out.println("Data Imported");

        } catch (IOException e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportProducts() {
            int count = 0;
            try(PrintWriter out = new PrintWriter(new FileWriter("./output/export.txt"))){
                for(Account account : accountMap.values()){
                    StringBuilder accountrecord = new StringBuilder();
                    accountrecord.append(account.getId())
                            .append(",")
                            .append(account.getName())
                            .append(",")
                            .append(account.getBalance())
                            .append(",")
                            .append(account.getType())
                            .append("\n");
                    out.write(accountrecord.toString());
                    count++;
                }
                System.out.println("Data exported "+count);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }


}


