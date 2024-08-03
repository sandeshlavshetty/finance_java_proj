// TransactionDao.java
package dao;

import model.Transaction;

import java.util.List;

public interface TransactionDao {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactionsByUser(String username);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int id);
}
