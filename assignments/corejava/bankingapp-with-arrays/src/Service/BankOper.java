package Service;

import Model.Account;

public interface BankOper {
    void createAccount(int id, String name, double balance, String type);

    Account[] getAllAccounts();

    Account getAccountById(int id);

    void updateBalance(int id, double newBalance);

    void deleteAccount(int id);
}


