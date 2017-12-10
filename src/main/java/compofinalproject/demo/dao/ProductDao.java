package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product findById(long id);
    Product addProduct(Product product);
    List<Product> findProduct(String searchName);
}
