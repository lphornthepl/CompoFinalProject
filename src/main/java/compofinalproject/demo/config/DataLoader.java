package compofinalproject.demo.config;


import compofinalproject.demo.dao.*;
import compofinalproject.demo.entity.*;
import compofinalproject.demo.entity.security.Authority;
import compofinalproject.demo.entity.security.AuthorityName;
import compofinalproject.demo.entity.security.User;
import compofinalproject.demo.security.repository.AuthorityRepository;
import compofinalproject.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@ConfigurationProperties(prefix = "server")
@Component
public class DataLoader  implements ApplicationRunner {
    VisitorDao visitorDao;


    @Autowired
    public void setVisitorDao(VisitorDao visitorDao) {
        this.visitorDao = visitorDao;
        User user1,user2,user3;

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    @Autowired
    public void setAuthorityRepository(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    AuthorityRepository authorityRepository;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    ProductDao productDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    CustomerDao customerDao;
    User user1,user2,user3;


    TransactionDao transactionDao;

    @Autowired
    public void setTransactionDaoDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    ShopkeeperDao shopkeeperDao;

    @Autowired
    public void setShopkeeperDao(ShopkeeperDao shopkeeperDao) {
        this.shopkeeperDao = shopkeeperDao;
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


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;
        Product product1 = Product.builder().productId("001").productName("Mama").image(imageBaseUrl+"mama.jpg").price(15).amount(1).description("mama").build();
        Product product2 = Product.builder().productId("002").productName("Cookie").image(imageBaseUrl+"cookie.jpg").price(10).amount(1).description("Homemade Cookie").build();
        Product product3 = Product.builder().productId("003").productName("Lay").image(imageBaseUrl+"lay.jpg").price(25).amount(1).description("Lay Big size").build();
        Product product4 = Product.builder().productId("004").productName("Bento").image(imageBaseUrl+"bento.jpg").price(10).amount(1).description("spicy bento").build();
        Product product5 = Product.builder().productId("005").productName("Tawan").image(imageBaseUrl+"tawan.jpg").price(20).amount(1).description("tawan original").build();
        Product product6 = Product.builder().productId("006").productName("Coke").image(imageBaseUrl+"coke.jpg").price(20).amount(1).description("sugar free coke").build();

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
        Customer customer3 = Customer.builder().CustomerId(003).CustomerName("siriganya").CustomerSurname("supa")
                .username("bambam").password("eiei").moreInformation("101/001 bra bra bra").build();


        customerDao.addCustomer(customer1);
        customerDao.addCustomer(customer2);
        customerDao.addCustomer(customer3);

        Shopkeeper shopkeeper1 = Shopkeeper.builder().ShopkeeperId(501).ShopkeeperName("Kitipan").ShopkeeperSurname("panyapuhin")
                .username("jamez").password("jamezeiei").moreInformation("eiei").build();
        Shopkeeper shopkeeper2 = Shopkeeper.builder().ShopkeeperId(502).ShopkeeperName("Ranate").ShopkeeperSurname("srinoi")
                .username("xsister").password("xsister").moreInformation("hahaha").build();

        shopkeeperDao.addShopkeeper(shopkeeper1);
        shopkeeperDao.addShopkeeper(shopkeeper2);

        Transaction transaction1 = Transaction.builder().date("22-07-2017").typeOfPayment("Transfer").build();
        transactionDao.addTransaction(transaction1);
        transaction1.addProduct(product1);
        transaction1.addProduct(product2);

        Transaction transaction2 = Transaction.builder().date("05-06-2017").typeOfPayment("PayPal").build();
        transactionDao.addTransaction(transaction2);
        transaction2.addProduct(product3);
        transaction2.addProduct(product4);


        Visitor visitor1 = Visitor.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl + "mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Visitor visitor2 = Visitor.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl + "tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Visitor visitor3 = Visitor.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl + "Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        visitorDao.addVisitor(visitor1);
        visitorDao.addVisitor(visitor2);
        visitorDao.addVisitor(visitor3);

        securitySetup();

        visitor1.setUser(user1);
        user1.setVisitor(visitor1);
        visitor2.setUser(user2);
        user2.setVisitor(visitor2);
        visitor3.setUser(user3);
        user3.setVisitor(visitor3);
    }



    private void securitySetup() {
        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_CUSTOMER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_SHOPKEEPER).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);
        user1 = User.builder()
                .username("admin")
                .password("admin")
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("shopkeeper")
                .password("shopkeeper")
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("customer")
                .password("customer")
                .firstname("user")
                .lastname("user")
                .email("disabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user1.setAuthorities(new ArrayList<>());
        user1.getAuthorities().add(auth3);
        user2.setAuthorities(new ArrayList<>());
        user2.getAuthorities().add(auth2);
        user3.setAuthorities(new ArrayList<>());
        user3.getAuthorities().add(auth1);
        userRepository .save(user1);
        userRepository .save(user2);
        userRepository .save(user3);


    }
}
