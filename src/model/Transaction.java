
package model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Transaction {
    private static int idCounter = 0;
    private int id;
    private double amount;
    private LocalDate date;
    private String category;
    private String description;
    private String username;

    public Transaction(double amount, LocalDate date, String category, String description, String username) {
        this.id = ++idCounter;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("Transaction{id=%d, amount=%.2f, date=%s, category='%s', description='%s', username='%s'}",
                id, amount, date, category, description, username);
    }
}
