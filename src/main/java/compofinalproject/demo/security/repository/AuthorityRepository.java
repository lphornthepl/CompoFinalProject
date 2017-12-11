package compofinalproject.demo.security.repository;

import compofinalproject.demo.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository  extends JpaRepository<Authority,Long> {
}
