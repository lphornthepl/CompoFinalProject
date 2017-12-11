package compofinalproject.demo.dao;

import com.google.common.collect.Lists;
import compofinalproject.demo.entity.Visitor;
import compofinalproject.demo.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("DBDataSource")
public class VisitorDaoImpl implements VisitorDao {

    VisitorRepository visitorRepository;
    @Autowired
    public void setAccountRepository(VisitorRepository visitorRepository){
        this.visitorRepository = visitorRepository;
    }
    @Override
    public List<Visitor> getVisitors() {

        return Lists.newArrayList(visitorRepository.findAll());

    }

    @Override
    public Visitor findById(long id) {
        return visitorRepository.findById(id);
    }

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor findByUsername(String username) {
        return visitorRepository.findByUserUsername(username);
    }

    @Override
    public Integer size() {
        return (int) visitorRepository.count();
    }
}
