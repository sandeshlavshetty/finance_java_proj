//savinggoal controller
package controller;

import model.SavingsGoal;
import service.SavingsGoalService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SavingsGoalController {
    private SavingsGoalService savingsGoalService;

    public SavingsGoalController(SavingsGoalService savingsGoalService) {
        this.savingsGoalService = savingsGoalService;
    }

    public void addSavingsGoal(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter goal name: ");
        String name = scanner.nextLine();

        System.out.print("Enter target amount: ");
        double targetAmount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter target date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate targetDate = LocalDate.parse(dateStr);

        SavingsGoal savingsGoal = new SavingsGoal(name, targetAmount, targetDate, username);
        //savingsGoalService.addSavingsGoal(name, targetAmount, targetDate, username);
        savingsGoalService.addSavingsGoal(savingsGoal);
        System.out.println("Savings goal added successfully!");
    }

    public void viewSavingsGoals(String username) {
        List<SavingsGoal> goals = savingsGoalService.getSavingsGoalsByUser(username);
        for (SavingsGoal goal : goals) {
            System.out.println(goal);
        }
    }

    public void updateSavingsGoal(String username) { 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter goal ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new goal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new target amount: ");
        double targetAmount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new target date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate targetDate = LocalDate.parse(dateStr);
        List<SavingsGoal> goals = savingsGoalService.getSavingsGoalsByUser(username);
        SavingsGoal savingsGoalToUpdate = null;
        for (SavingsGoal goal : goals){
            if (goal.getId() == id) {
                savingsGoalToUpdate = goal;
                break;
            }
        }

        if (savingsGoalToUpdate == null){
            System.out.println("Goal not found");
            return;
        }
        savingsGoalToUpdate.setName(name);
        savingsGoalToUpdate.setTargetAmount(targetAmount);
        savingsGoalToUpdate.setTargetDate(targetDate);
        

        // SavingsGoalService.updateSavingsGoal(savingsGoalToUpdate)
        savingsGoalService.updateSavingsGoal(savingsGoalToUpdate);
        System.out.println("Savings goal updated successfully!");
    }
    
    public void deleteSavingsGoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Goal ID to delete: ");
        int goalId = scanner.nextInt();
        savingsGoalService.deleteSavingsGoal(goalId);
        System.out.println("Savings goal deleted successfully!");
    }
}
