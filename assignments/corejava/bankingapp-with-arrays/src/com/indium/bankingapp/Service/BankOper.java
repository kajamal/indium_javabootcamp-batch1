package com.indium.bankingapp.Service;

import com.indium.bankingapp.Model.Account;

public interface BankOper {

    void createAccount(Account account);
    Account[] getAllAccounts();
    Account getAccountById(int id);
    void updateBalance(Account account, double newBalance);
    void deleteAccount(int id);
}


