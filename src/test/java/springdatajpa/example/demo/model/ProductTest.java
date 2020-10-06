package springdatajpa.example.demo.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import springdatajpa.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {

    private static final Logger log = LogManager.getLogger(ProductTest.class);

    @Autowired
    private ProductRepository repo;

    @Test
    void testCreateProduct(){
        Product product = new Product("Iphone 10", 789);
        repo.save(product);
    }

    @Test
    @Sql({"/insertIntoProduct.sql"})
    void findByName(){
        List<Product> p = repo.findByName("Iphone 10");
        Assertions.assertNotNull(p);
        for (Product pp : p){
            log.info(pp.toString());
        }
    }


    @Test
    @Sql({"/insertIntoProduct.sql"})
    void findByNameAndPrice(){
        List<Product> p = repo.findByNameAndPrice("Iphone 10", 789);
        Assertions.assertNotNull(p);
        for (Product pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoProduct.sql"})
    void findByNameAndPriceFail(){
        List<Product> p = repo.findByNameAndPrice("Iphone 10", 78);
        Assertions.assertNotNull(p);
        for (Product pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoProduct.sql"})
    void findByNameOrPrice(){
        List<Product> p = repo.findByNameOrPrice("Iphone 10", 78);
        Assertions.assertNotNull(p);
        for (Product pp : p){
            log.info(pp.toString());
        }
    }


//    @Test
//    @Sql({"/insertIntoProduct.sql"})
//    void findByFirstName() throws Exception{
//        try{
//            List<Product> p = repo.findByFirstName("Iphone 10");
//            for (Product pp : p){
//                log.info(pp.toString());
//            }
//        }catch(Exception e){
//            log.info(e.getMessage());
//
//        }
//
//    }

}