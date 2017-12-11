package compofinalproject.demo.service;

import compofinalproject.demo.dao.VisitorDao;
import compofinalproject.demo.entity.Visitor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorDao visitorDao;
    public List<Visitor> getVisitors(){

        return visitorDao.getVisitors();
    }

    @Override
    @Transactional
    public Visitor findById(long id) {
        Visitor visitor = visitorDao.findById(id);
//        Hibernate.initialize(account.getEnrolledCourse());
        return visitor;
    }

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorDao.addVisitor(visitor);
    }

    @Transactional
    @Override
    public Visitor getVisitorForTransfer(String username) {
        Visitor visitor = visitorDao.findByUsername(username);
        Hibernate.initialize(visitor.getAuthorities());
        return visitor;
    }
}
