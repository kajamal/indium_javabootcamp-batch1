package com.indium.bankingapp.Model.Service;

import com.indium.bankingapp.Model.Account;

public interface BankOper {

    void createAccount(int id, String name, double balance, String type);
    Account[] getAllAccounts();
    Account getAccountById(int id);
    void updateBalance(int id, double newBalance);
    void deleteAccount(int id);
}


