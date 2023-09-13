package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;

import java.util.List;
import java.util.Map;

public interface BankOperation {

    void createAccount(int id, String name, int balance, String type);
    Account[] getAllAccounts();
    Account getAccountById(int id);
    void updateBalance(int id, int newBalance);
    void deleteAccount(int id);
    int countAccountsAboveOneLac();
    Map<String, Integer> countAccountsByType();
    Map<String, Integer>countAndSortAccountsByType();
    Map<String, Integer> calculateAvgBalanceByType();
    List<Integer> getAccountIdsByName(String name);
}
