import com.indium.bankapp.Model.Account;
import com.indium.bankapp.Service.AccountServiceHashMapImplement;


import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        AccountServiceHashMapImplement accountService = new AccountServiceHashMapImplement();
        ExecutorService executor = Executors.newCachedThreadPool();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Account Management Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. View Account by ID");
            System.out.println("4. Update Account Balance");
            System.out.println("5. Delete Account");
            System.out.println("6. Print Statistics");
            System.out.println("7. Import Data");
            System.out.println("8. Export Data");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter Account Id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Account Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Balance: ");
                    int balance = scanner.nextInt();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.next();
                    Account newAccount = new Account(id, name, balance, type);
                    accountService.createAccount(newAccount);

                    break;
                case 2:

                    Account[] allAccounts = accountService.getAllAccounts();
                    for (Account account : allAccounts) {
                        System.out.println(account);

                    }
                    break;
                case 3:

                    System.out.print("Enter Account Id to view: ");
                    int viewId = scanner.nextInt();
                    Account viewAccount = accountService.getAccountById(viewId);
                    if (viewAccount != null) {
                        System.out.println(viewAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Account ID to update balance: ");
                    int updateId = scanner.nextInt();
                    Account updateAccount = accountService.getAccountById(updateId);
                    if (updateAccount != null) {
                        System.out.print("Enter the new amount : ");
                        int newBalance = scanner.nextInt();
                        accountService.updateBalance(updateAccount, newBalance);
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;

                case 5:

                    System.out.print("Enter Account Id to delete: ");
                    int deleteId = scanner.nextInt();
                    accountService.deleteAccount(deleteId);
                    break;
                case 6:
                    printStatistics(accountService);
                    break;
                case 7:
                    Callable<Boolean> importThread = new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println(Thread.currentThread()+" is importing data");
                            accountService.importProducts();
                            return true;
                        }
                    };
                    Future<Boolean> importFuture = executor.submit(importThread);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 8:
                    Callable<Boolean> exportThread = new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println(Thread.currentThread()+" is exporting data");
                            accountService.exportProducts();
                            return true;
                        }
                    };
                    Future<Boolean> exportFuture = executor.submit(exportThread);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 9:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);


    }

    private static void printStatistics(AccountServiceHashMapImplement accountService) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Statistics:");
        int accountsAboveOneLac = accountService.countAccountsAboveOneLac();
        System.out.println("No of accounts which have a balance more than 1 lac: " + accountsAboveOneLac);

        System.out.println("No of account by account type:");
        accountService.countAccountsByType().forEach((type, count) ->
                System.out.println(type + ": " + count)
        );

        System.out.println(" No of accounts by account type with sorting:");
        accountService.countAndSortAccountsByType().forEach((type, count) ->
                System.out.println(type + ": " + count)
        );
        System.out.println("Avg balance by account type:");
        accountService.calculateAvgBalanceByType().forEach((type, avgBalance) ->
                System.out.println(type + ": " + avgBalance)
        );
        System.out.print("Enter the partial name: ");
        String partialName = sc.nextLine();
        System.out.println("Listing the account ids whose account name contains '" + partialName + "':");
        accountService.getAccountIdsByName(partialName).forEach((accountId, accountName) -> {
            System.out.println("Account ID: " + accountId + ", Account Name: " + accountName);
        });

    }
}