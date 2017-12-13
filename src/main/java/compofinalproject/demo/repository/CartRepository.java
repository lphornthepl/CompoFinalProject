package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {
}
