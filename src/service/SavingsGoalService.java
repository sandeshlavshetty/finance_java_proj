// SavingsGoalService.java
package service;

import model.SavingsGoal;
import dao.SavingsGoalDao;

import java.time.LocalDate;
import java.util.List;

public class SavingsGoalService {
    private SavingsGoalDao savingsGoalDao;

    public SavingsGoalService(SavingsGoalDao savingsGoalDao) {
        this.savingsGoalDao = savingsGoalDao;
    }

    

    public void addSavingsGoal(SavingsGoal SavingsGoal){
        savingsGoalDao.addSavingsGoal(SavingsGoal);
    }

    public List<SavingsGoal> getSavingsGoalsByUser(String username) {
        return savingsGoalDao.getSavingsGoalsByUser(username);
    }

    public void updateSavingsGoal(SavingsGoal savingsGoal) {
        savingsGoalDao.updateSavingsGoal(savingsGoal);
    }

    public void deleteSavingsGoal(int id) {
        savingsGoalDao.deleteSavingsGoal(id);
    }
}
