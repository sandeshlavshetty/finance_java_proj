import controller.TransactionController;
import controller.CategoryController;
import controller.SavingsGoalController;
import controller.UserController;
import service.TransactionService;
import service.CategoryService;
import service.SavingsGoalService;
import service.UserService;
import dao.InMemoryTransactionDao;
import dao.InMemoryCategoryDao;
import dao.InMemorySavingsGoalDao;
import dao.InMemoryUserDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize services and controllers
        UserService userService = new UserService(new InMemoryUserDao());
        TransactionService transactionService = new TransactionService(new InMemoryTransactionDao());
        CategoryService categoryService = new CategoryService(new InMemoryCategoryDao());
         SavingsGoalService savingsGoalService = new SavingsGoalService(new InMemorySavingsGoalDao());


        // Initialize controllers
        UserController userController = new UserController(userService);
        TransactionController transactionController = new TransactionController(transactionService);
        CategoryController categoryController = new CategoryController(categoryService);
         SavingsGoalController savingsGoalController = new SavingsGoalController(savingsGoalService);


        Scanner scanner = new Scanner(System.in);
        String currentUsername = null;

        while (true) {
            if (currentUsername == null) {
                // User not logged in, show login/register options
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        userController.register();
                        break;
                    case 2:
                        if (userController.login()) {
                            currentUsername = userService.getCurrentUsername();
                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                // User is logged in, show transaction and category options
                System.out.println("1. Add Transaction");
                System.out.println("2. View Transactions");
                System.out.println("3. Update Transaction");
                System.out.println("4. Delete Transaction");
                System.out.println("5. Add Category");
                System.out.println("6. View Categories");
                System.out.println("7. Delete Category");
                System.out.println("8. Add Savings Goal");
                System.out.println("9. View Savings Goals");
                System.out.println("10. Update Savings Goal");
                System.out.println("11. Delete Savings Goal");
                System.out.println("12. Logout");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        transactionController.addTransaction(currentUsername);
                        break;
                    case 2:
                        transactionController.viewTransactions(currentUsername);
                        break;
                    case 3:
                        transactionController.updateTransaction(currentUsername);
                        break;
                    case 4:
                        transactionController.deleteTransaction(currentUsername);
                        break;
                    case 5:
                        categoryController.addCategory(currentUsername);
                        break;
                    case 6:
                        categoryController.viewCategories(currentUsername);
                        break;
                    case 7:
                        categoryController.deleteCategory(currentUsername);
                        break;
                    case 8:
                    savingsGoalController.addSavingsGoal(currentUsername);
                    break;
                    case 9:
                    savingsGoalController.viewSavingsGoals(currentUsername);
                    break;
                    case 10:
                    savingsGoalController.updateSavingsGoal(currentUsername);
                    break;
                    case 11:
                    savingsGoalController.deleteSavingsGoal();
                    break;
                    case 12:
                        userService.logoutUser();
                        currentUsername = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
