package springdatajpa.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdatajpa.example.demo.model.Person;
import springdatajpa.example.demo.model.PersonDto;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);

    @Query("from Person as p")
    List<Person> findAll();

    @Query(value="from Person as p where p.firstName=:firstName")
    List<Person> findByFirstNameCustom(@Param("firstName") String firstName);


    @Query(value="select new springdatajpa.example.demo.model.PersonDto(p.firstName, p.lastName, p.address) FROM Person p where p.firstName = :firstName")
    List<PersonDto> findByFirstNameDto(@Param("firstName") String firstName);

    @Query(value="select * from Person", nativeQuery = true)
    List<Person> findAllNative();

    @Query(nativeQuery = true)
    List<PersonDto> findByFirstNameDtoNative(@Param("firstName") String firstName);


    List<Person> findByFirstNameNamedQuery(@Param("firstName") String firstName);


    List<Person> findByFirstNameNamedNativeQuery(@Param("firstName") String firstName);


    @Query(nativeQuery = true)
    List<PersonDto> findByFirstNameOrLastNameOrAddressDtoNative(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("address") String address
            );

//  Interface projection

//  Derived query
    List<PersonView> findByFirstNameOrLastName(String firstName, String lastName);

//  Custom query
    @Query(value="SELECT p FROM Person p WHERE p.firstName = :firstName")
    List<PersonView> findByFirstNamePersonView(@Param("firstName") String firstName);

//  Native Custom query
    @Query(value="SELECT p.firstName, p.lastName FROM Person p WHERE p.firstName = :firstName", nativeQuery = true)
    List<PersonView> findByFirstNameNativePersonView(@Param("firstName")String firstName);

//  Named Native Custom query
    @Query(nativeQuery = true)
    List<PersonView> findByFirstNameNamedNativePersonView(@Param("firstName") String firstName);


    //    Will fail, but worth to notice
//    @Query(value="SELECT p.firstName, p.lastName FROM Person p WHERE p.firstName = :firstName")
//    List<PersonView> findByFirstNamePersonView(@Param("firstName") String firstName);

}
