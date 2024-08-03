// InMemoryTransactionDao.java
package dao;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTransactionDao implements TransactionDao {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByUser(String username) {
        return transactions.stream()
                .filter(transaction -> transaction.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == transaction.getId()) {
                transactions.set(i, transaction);
                break;
            }
        }
    }

    @Override
    public void deleteTransaction(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
    }
}

