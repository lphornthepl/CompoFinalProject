package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Visitor;

import java.util.List;

public interface VisitorDao {

        List<Visitor> getVisitors();

        Visitor findById(long id);

        Visitor addVisitor(Visitor visitor);

        Visitor findByUsername(String username);

        Integer size();

}
