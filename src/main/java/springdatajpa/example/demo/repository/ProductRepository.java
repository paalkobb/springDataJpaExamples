package springdatajpa.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatajpa.example.demo.model.Product;

import java.util.List;


// Derived queries
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // If you change the 'name' variable in the Product class
    // This will throw an exception, because of faulty
    // naming convention
    List<Product> findByName(String name);

    List<Product> findByPrice(float price);

    List<Product> findByNameAndPrice(String name, float price);

    List<Product> findByNameOrPrice(String name, float price);

    List<Product> findByPriceOrderByNameAsc(float price);

    List<Product> findByNameContainsAndPriceBetween(String name, float start, float end);

    List<Product> findByNameContainsAndPriceBetweenOrderByPriceAsc(String name, float start, float end);




}
