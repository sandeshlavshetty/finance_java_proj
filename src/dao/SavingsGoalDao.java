// SavingsGoalDao.java
package dao;

import model.SavingsGoal;
import java.util.List;

public interface SavingsGoalDao {
    void addSavingsGoal(SavingsGoal savingsGoal);
    List<SavingsGoal> getSavingsGoalsByUser(String username);
    void updateSavingsGoal(SavingsGoal savingsGoal);
    void deleteSavingsGoal(int id);
}

