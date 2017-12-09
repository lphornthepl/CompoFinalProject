package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findById(Long id);
}
