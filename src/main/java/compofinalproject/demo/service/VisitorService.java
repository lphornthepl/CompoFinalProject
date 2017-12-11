package compofinalproject.demo.service;

import compofinalproject.demo.entity.Visitor;

import java.util.List;

public interface VisitorService {
    List<Visitor> getVisitors();
    Visitor findById(long id);
    Visitor addVisitor(Visitor visitor);
    Visitor getVisitorForTransfer(String username);
}
