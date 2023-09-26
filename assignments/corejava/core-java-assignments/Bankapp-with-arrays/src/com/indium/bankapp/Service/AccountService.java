package com.indium.bankapp.Service;

import com.indium.bankapp.Model.Account;

    public interface AccountService {
        void createAccount(Account account);
        Account[] getAllAccounts();
        Account getAccountById(int id);
        void updateBalance(Account account, int newBalance);
        void deleteAccount(int id);
    }

