package compofinalproject.demo.service;

import compofinalproject.demo.dao.TransactionDao;
import compofinalproject.demo.entity.Product;
import compofinalproject.demo.entity.Transaction;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public List<Transaction> getTransactions(){

        return transactionDao.getTransactions();
    }

    @Override
    @Transactional
    public Transaction findById(long id) {
        Transaction transaction = transactionDao.findById(id);
        //Hibernate.initialize(student.getEnrolledCourse());
        return transaction;
    }

    @Override
    public List<Transaction> queryTransaction(String query) {
        if (query == null || query.equals("")) {
            return transactionDao.getTransactions();
        }
        return transactionDao.getTransactionSearch(query);
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionDao.addTransaction(transaction);
    }
}
