// TransactionController.java
package controller;

import model.Transaction;
import service.TransactionService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TransactionController {
    private TransactionService transactionService;
    private SimpleDateFormat dateFormat;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void addTransaction(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter transaction date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        System.out.print("Enter transaction category: ");
        String category = scanner.nextLine();

        System.out.print("Enter transaction description: ");
        String description = scanner.nextLine();

        Transaction transaction = new Transaction(amount, LocalDate.parse(dateStr), category, description, username);
        transactionService.addTransaction(transaction);
        System.out.println("Transaction added successfully!");
    }

    public void viewTransactions(String username) {
        List<Transaction> transactions = transactionService.getTransactionsByUser(username);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);  // This will call the toString() method
        }
    }

    public void updateTransaction(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter new amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter new date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        System.out.print("Enter new category: ");
        String category = scanner.nextLine();

        System.out.print("Enter new description: ");
        String description = scanner.nextLine();

        // Retrieve the existing transaction
        List<Transaction> transactions = transactionService.getTransactionsByUser(username);
        Transaction transactionToUpdate = null;
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                transactionToUpdate = transaction;
                break;
            }
        }

        if (transactionToUpdate == null) {
            System.out.println("Transaction not found!");
            return;
        }

        // Update the transaction details
        transactionToUpdate.setAmount(amount);
        transactionToUpdate.setDate(LocalDate.parse(dateStr));
        transactionToUpdate.setCategory(category);
        transactionToUpdate.setDescription(description);

        transactionService.updateTransaction(transactionToUpdate);
        System.out.println("Transaction updated successfully!");
    }

    public void deleteTransaction(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction ID to delete: ");
        int transactionId = scanner.nextInt();
        transactionService.deleteTransaction(transactionId);
        System.out.println("Transaction deleted successfully!");
    }
}
