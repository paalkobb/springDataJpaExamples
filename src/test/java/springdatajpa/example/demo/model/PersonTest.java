package springdatajpa.example.demo.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import springdatajpa.example.demo.repository.PersonRepository;
import springdatajpa.example.demo.repository.PersonView;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class PersonTest {

    private static final Logger log = LogManager.getLogger(ProductTest.class);

    @Autowired
    PersonRepository repo;


    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findAll(){
        List<Person> p = repo.findAll();
        for (Person pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstName(){
        List<Person> p = repo.findByFirstName("markus");
        for (Person pp : p){
            log.info(pp.toString());
        }
    }



    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findAllNative(){
        List<Person> p = repo.findAllNative();
        for (Person pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameCustom(){
        List<Person> p = repo.findByFirstNameCustom("markus");
        for (Person pp : p){
            log.info(pp.toString());
        }
    }


    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameDto(){
        List<PersonDto> p = repo.findByFirstNameDto("markus");
        for (PersonDto pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameDtoNative(){
        List<PersonDto> p = repo.findByFirstNameDtoNative("markus");
        for (PersonDto pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameOrLastNameOrAddressDtoNative(){
        List<PersonDto> p = repo.findByFirstNameOrLastNameOrAddressDtoNative("anders", "Knutson", "geirsgate");
        for (PersonDto pp : p){
            log.info(pp.toString());
        }
    }


    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameOrLastName(){
        List<PersonView> p = repo.findByFirstNameOrLastName("anders", "knutson");
        for (PersonView pp : p){
            log.info("First name: "  + pp.getFirstName());
            log.info("Last name: " + pp.getLastName());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNamePersonView(){
        List<PersonView> p = repo.findByFirstNamePersonView("xin");
        for (PersonView pp : p){
            log.info("First name: "  + pp.getFirstName());
            log.info("Last name: " + pp.getLastName());
        }
    }


    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameNativePersonView(){
        List<PersonView> p = repo.findByFirstNameNativePersonView("xin");
        for (PersonView pp : p){
            log.info("First name: "  + pp.getFirstName());
            log.info("Last name: " + pp.getLastName());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameNamedNativePersonView(){
        List<PersonView> p = repo.findByFirstNameNamedNativePersonView("anders");
        for (PersonView pp : p){
            log.info("First name: "  + pp.getFirstName());
            log.info("Last name: " + pp.getLastName());
        }
    }


    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameNamedQuery(){
        List<Person> p = repo.findByFirstNameNamedQuery("per");
        for (Person pp : p){
            log.info(pp.toString());
        }
    }

    @Test
    @Sql({"/insertIntoPerson.sql"})
    void findByFirstNameNamedNativeQuery(){
        List<Person> p = repo.findByFirstNameNamedNativeQuery("per");
        for (Person pp : p){
            log.info(pp.toString());
        }
    }

}