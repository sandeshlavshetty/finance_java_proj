// SavingsGoal.java   
package model;

import java.time.LocalDate;

public class SavingsGoal {
    private static int idCounter = 0;
    private int id;
    private String name;
    private double targetAmount;
    private LocalDate targetDate;
    private String username;
    

    // Constructor with parameters
    public SavingsGoal(String name, double targetAmount, LocalDate targetDate, String username) {
        this.id = ++idCounter;
        this.name = name;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
        this.username = username;
    }


public void setName(String name) {
    this.name = name;
}

public void setTargetAmount(double targetAmount) {
    this.targetAmount = targetAmount;
}

public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
}

public void setUsername(String username) {
    this.username = username;
}

    // Getters 
    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "SavingsGoal{" +
                "name='" + name + '\'' +
                ", targetAmount=" + targetAmount +
                ", targetDate=" + targetDate +
                ", username='" + username + '\'' +
                ", Id='"+id+'\''+ 
                '}';
    }
}
