import com.indium.bankapp.Model.Account;
import com.indium.bankapp.Service.HashmapStats;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashmapStats accountService = new HashmapStats();
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
            System.out.println("7. Exit");
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
                    accountService.createAccount(id, name, balance, type);

                    break;
                case 2:

                    Account[] allAccounts = accountService.getAllAccounts();
                    for (Account account : allAccounts) {
                        System.out.println(account);
                        System.out.println();
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

                    System.out.print("Enter Account Id to update balance: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Balance: ");
                    int newBalance = scanner.nextInt();
                    accountService.updateBalance(updateId, newBalance);
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
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);


    }

    private static void printStatistics(HashmapStats accountService) {
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
        accountService.getAccountIdsByName(partialName).forEach(System.out::println);


    }


}