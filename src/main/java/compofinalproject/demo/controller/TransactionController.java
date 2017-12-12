package compofinalproject.demo.controller;

import compofinalproject.demo.entity.Transaction;
import compofinalproject.demo.service.TransactionService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class TransactionController {
    TransactionService transactionService;
    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @CrossOrigin
    @GetMapping("/transaction")
    public ResponseEntity<?> getTransactions() {
        List<Transaction> transactions = transactionService.getTransactions();
        return ResponseEntity.ok(transactions);
    }

    @CrossOrigin
    @GetMapping("transaction/{id}")
    public ResponseEntity getStudent(@PathVariable("id")long id){
        Transaction transaction = transactionService.findById(id);
        if (transaction!= null)
            return ResponseEntity.ok(transaction);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @Value("${server.baseUrl}")
    String baseUrl;
    @Value("${server.imageUrl}")
    String imageUrl;
    @Value("${server.imageServerDir}")
    String imageServerDir;
    @PostMapping("/uploads")
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            byte[] bytes = file.getBytes();
            String oldFilename = file.getOriginalFilename();
            String ext = FilenameUtils.getExtension(oldFilename);
            String newFilename = Integer.toString(LocalTime.now().hashCode(),16)+Integer.toString(oldFilename.hashCode(),16)+"."+ext;
            Path path = Paths.get(imageServerDir+newFilename);
            Files.write(path,bytes);
            return ResponseEntity.ok(baseUrl+ imageUrl + newFilename);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> queryProduct(@RequestParam("search") String query) {
        List<Transaction> transactions = transactionService.queryTransaction(query);
        if (transactions != null)
            return ResponseEntity.ok(transactions);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
