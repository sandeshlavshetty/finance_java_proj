// TransactionService.java
package service;

import dao.TransactionDao;
import model.Transaction;

import java.util.List;

public class TransactionService {
    private TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void addTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
    }

    public List<Transaction> getTransactionsByUser(String username) {
        return transactionDao.getTransactionsByUser(username);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDao.updateTransaction(transaction);
    }

    public void deleteTransaction(int id) {
        transactionDao.deleteTransaction(id);
    }
}

