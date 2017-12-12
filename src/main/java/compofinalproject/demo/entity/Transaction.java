package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String Date;

    String typeOfPayment;


    @ManyToMany
    List<Product> productList;

    public List<Product> addProduct(Product product){
        productList = Optional.ofNullable(productList).orElse(new ArrayList<>());
        productList.add(product);
        return productList;
    }

}
