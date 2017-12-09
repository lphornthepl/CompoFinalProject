package compofinalproject.demo.config;


import compofinalproject.demo.dao.ProductDao;
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
        Product product1 = Product.builder().productId("001").productName("Mama").image("").price(15).Amount(1).description("mama").build();
        Product product2 = Product.builder().productId("002").productName("Cookie").image("").price(10).Amount(1).description("Homemade Cookie").build();

        productDao.addProduct(product1);
        productDao.addProduct(product2);



    }
}
