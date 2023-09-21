package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;

import java.util.Map;

public interface AccountService {

    void createAccount(Account account);
    Account[] getAllAccounts();
    Account getAccountById(int id);
    void updateBalance(Account account, int newBalance);
    void deleteAccount(int id);
    void importProducts();
    void exportProducts();
    int countAccountsAboveOneLac();
    Map<String, Integer> countAccountsByType();
    Map<String, Integer>countAndSortAccountsByType();
    Map<String, Double> calculateAvgBalanceByType();
    Map<Integer, String> getAccountIdsByName(String partialName);



}
