package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;
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
        public long countAccountsAboveOneLac() {
            return accountMap.values()
                    .stream()
                    .filter(account -> account.getBalance() > 100000)
                    .count();
        }

        @Override
        public Map<String,Long> countAccountsByType() {
            return accountMap.values()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Account::getType,
                            Collectors.counting()
                    ));
        }

        @Override
        public Map<String, Long> countAndSortAccountsByType() {
            return accountMap.values()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Account::getType,
                            TreeMap::new,
                            Collectors.counting()
                    ));
        }

        public Map<String, Double> calculateAvgBalanceByType() {
            return accountMap.values()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Account::getType,
                            Collectors.averagingInt(Account::getBalance)
                    ));
        }
        @Override
        public Map<Integer, String> getAccountIdsByName(String partialName) {
            return accountMap.values()
                    .stream()
                    .filter(account -> account.getName().contains(partialName))
                    .collect(Collectors.toMap(
                            Account::getId,
                            Account::getName
                    ));

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
