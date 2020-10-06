package springdatajpa.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@SqlResultSetMappings(
        {@SqlResultSetMapping(
                name = "PersonDtoNativeMapper",
                classes = @ConstructorResult(
                        targetClass = PersonDto.class,
                        columns = {
                                @ColumnResult(name = "firstName", type = String.class),
                                @ColumnResult(name = "lastName", type = String.class),
                                @ColumnResult(name = "address", type = String.class)
                        })
        ),
        @SqlResultSetMapping(
                name = "PersonMapping",
                classes = @ConstructorResult(
                        targetClass = Person.class,
                        columns = {
                                @ColumnResult(name = "firstName"),
                                @ColumnResult(name = "lastName"),
                                @ColumnResult(name = "age"),
                                @ColumnResult(name = "address"),
                                @ColumnResult(name = "gender")
                        }
                )
        )}
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Person.findByFirstNameDtoNative",
                query = "select p.firstName, p.lastName, p.address FROM Person p where p.firstName = :firstName",
                resultSetMapping = "PersonDtoNativeMapper"
        ),
        @NamedNativeQuery(
                name = "Person.findByFirstNameOrLastNameOrAddressDtoNative",
                query = "SELECT p.firstName, p.lastName, p.address FROM Person p WHERE p.firstName = :firstName OR p.lastName = :lastName or p.address = :address",
                resultSetMapping = "PersonDtoNativeMapper"
        ),
        @NamedNativeQuery(
                name = "Person.findByFirstNameNamedNativePersonView",
                query = "SELECT p.firstName, p.lastName FROM Person p WHERE p.firstName = :firstName"
        ),
        @NamedNativeQuery(
                name="Person.findByFirstNameNamedNativeQuery",
                query="SELECT * FROM Person p WHERE p.firstName = :firstName",
                resultSetMapping = "PersonMapping"
        )
    }
)
@NamedQuery(
        name = "Person.findByFirstNameNamedQuery",
        query = "FROM Person p where p.firstName = :firstName"
)
@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public String firstName;
    public String lastName;
    Integer age;
    String address;
    String gender;

    public Person(){
    }

    public Person(String firstName, String lastName){
        this(firstName, lastName, null, null, null);
    }

    public Person(String firstName, String lastName, Integer age, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


}
