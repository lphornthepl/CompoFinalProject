package compofinalproject.demo.dao;

import com.google.common.collect.Lists;
import compofinalproject.demo.entity.Product;
import compofinalproject.demo.entity.Transaction;
import compofinalproject.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Profile("TransactionDataSource")
@Repository
public class TransactionDaoImpl implements TransactionDao {

    TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transaction> getTransactions() {

        return Lists.newArrayList(transactionRepository.findAll());

    }

    @Override
    @Transactional
    public List<Transaction> getTransactionSearch(String searchText) {
        return transactionRepository.findByTypeOfPaymentIgnoreCaseContainingOrDateIgnoreCaseContaining(searchText,searchText);
    }

    @Override
    public Transaction findById(long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction findByType(String searchType) {
        return null;
    }

}
