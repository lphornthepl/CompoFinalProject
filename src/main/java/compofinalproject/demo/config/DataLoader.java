package compofinalproject.demo.config;


import compofinalproject.demo.dao.CustomerDao;
import compofinalproject.demo.dao.ProductDao;
import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@ConfigurationProperties(prefix = "server")
@Component
public class DataLoader  implements ApplicationRunner {

    @Autowired
    ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;
        Product product1 = Product.builder().productId("001").productName("Mama").image(imageBaseUrl+"mama.jpg").price(15).Amount(1).description("mama").build();
        Product product2 = Product.builder().productId("002").productName("Cookie").image(imageBaseUrl+"cookie.jpg").price(10).Amount(1).description("Homemade Cookie").build();
        Product product3 = Product.builder().productId("003").productName("Lay").image(imageBaseUrl+"lay.jpg").price(25).Amount(1).description("Lay Big size").build();
        Product product4 = Product.builder().productId("004").productName("Bento").image(imageBaseUrl+"bento.jpg").price(10).Amount(1).description("spicy bento").build();
        Product product5 = Product.builder().productId("005").productName("Tawan").image(imageBaseUrl+"tawan.jpg").price(20).Amount(1).description("tawan original").build();
        Product product6 = Product.builder().productId("006").productName("Coke").image(imageBaseUrl+"coke.jpg").price(20).Amount(1).description("sugar free coke").build();

        productDao.addProduct(product1);
        productDao.addProduct(product2);
        productDao.addProduct(product3);
        productDao.addProduct(product4);
        productDao.addProduct(product5);
        productDao.addProduct(product6);

        Customer customer1 = Customer.builder().CustomerId(001).CustomerName("Apiwat").CustomerSurname("Hantrakool")
                .username("nekky").password("eiei").moreInformation("eiei i'm newbie").build();
        Customer customer2 = Customer.builder().CustomerId(002).CustomerName("passakorn").CustomerSurname("khunchai")
                .username("puparadox").password("eiei").moreInformation("411/145 bra bra bra").build();

        customerDao.addCustomer(customer1);
        customerDao.addCustomer(customer2);




    }
}
