package compofinalproject.demo.controller;

import compofinalproject.demo.entity.Visitor;
import compofinalproject.demo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {
    VisitorService visitorService;

    @Autowired
    public void setAccountService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @CrossOrigin
    @GetMapping("/visitor")
    public ResponseEntity<?> getAccounts() {

        List<Visitor> visitor = visitorService.getVisitors();
        return ResponseEntity.ok(visitor);
    }

    @CrossOrigin
    @GetMapping("visitor/{id}")
    public ResponseEntity getAccount(@PathVariable("id")long id){
        Visitor visitor = visitorService.findById(id);
        if (visitor != null)
            return ResponseEntity.ok(visitor);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    @PostMapping("/visitor")
    public ResponseEntity<?> uploadOnlyAccount(@RequestBody Visitor visitor){
        visitorService.addVisitor(visitor);
        return ResponseEntity.ok(visitor);
    }
}
