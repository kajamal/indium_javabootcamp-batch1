package Model;

public interface BankOper {
        void createaccount(Account account);
        void getAllAccounts();
        void viewAccount(int accountNumber);
        void updateAccount(int id, double newBalance);
        void deleteAccount(int accountNumber);
    }



