package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Visitor;
import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {
    Visitor findById(Long id);
    Visitor findByUserUsername(String username);
}
