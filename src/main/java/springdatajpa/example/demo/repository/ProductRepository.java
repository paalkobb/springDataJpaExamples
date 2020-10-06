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

    List<Product> findByNameAndPrice(String name, float price);

    List<Product> findByNameOrPrice(String name, float price);

    // Will throw an exception because no field with name 'firstName'
    // Worth to notice that the error message is 'firstName' with lower 'f'
    // But the method name is capital 'F'.
    // E.g Spring Data follows normal naming convention
//    List<Product> findByFirstName(String name);


}
