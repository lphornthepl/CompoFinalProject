package compofinalproject.demo.service;

import compofinalproject.demo.entity.Product;
import compofinalproject.demo.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();
    Transaction findById(long id);
    Transaction addTransaction(Transaction transaction);
    List<Transaction> queryTransaction(String query);
}
