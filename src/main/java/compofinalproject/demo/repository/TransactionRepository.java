package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Product;
import compofinalproject.demo.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository <Transaction,Long>{
   List<Transaction> findByTypeOfPaymentIgnoreCaseContainingOrDateIgnoreCaseContaining(String searchType, String searchDate);
    Transaction findById(Long id);
}
