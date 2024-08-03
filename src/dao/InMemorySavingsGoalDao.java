//InMemorySavingsGoalDao.java
package dao;

import model.SavingsGoal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemorySavingsGoalDao implements SavingsGoalDao {
    private List<SavingsGoal> savingsGoals = new ArrayList<>();

    @Override
    public void addSavingsGoal(SavingsGoal savingsGoal) {
        savingsGoals.add(savingsGoal);
    }

    @Override
    public List<SavingsGoal> getSavingsGoalsByUser(String username){
        return savingsGoals.stream()
                .filter(savingsGoals -> savingsGoals.getUsername().equals(username))
                .collect(Collectors.toList());
    }


    @Override
    public void updateSavingsGoal(SavingsGoal savingsGoal){
        for(int i=0;i<savingsGoals.size();i++){
            if(savingsGoals.get(i).getId() == savingsGoal.getId()){
                savingsGoals.set(i, savingsGoal);
                break;
            }
        }
    }

    @Override
    public void deleteSavingsGoal(int id){
        savingsGoals.removeIf(savingsGoal -> savingsGoal.getId() == id );
    }
}
