package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Product;
import compofinalproject.demo.entity.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getTransactions();
    List<Transaction> getTransactionSearch(String searchText);
    Transaction findById(long id);
    Transaction addTransaction(Transaction transaction);
}
