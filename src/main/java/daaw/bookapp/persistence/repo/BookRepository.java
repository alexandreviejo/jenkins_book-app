//*** USO DE Spring data JPA (Java Persistence API) -> implement JPA based repositories

//JPA is a specification that defines an API for object-relational mappings and for 
//managing persistent objects.
//Hibernate is a popular implementation of this specification

//Spring Data JPA adds a layer on top of JPA. That means it uses all features defined 
//by the JPA specification, especially the entity and association mappings, the entity 
//lifecycle management, and JPA’s query capabilities. On top of that, Spring Data JPA 
//adds its own features like a NO-CODE IMPLEMENTATION of the repository pattern
//creation of database queries from method names.
// -> OFRECEMOS UNA INTERFAZ que EXTIENDE CrudRepository. LA IMPLEMETACION LA PROPORCIONA
//SPRING!! Y YA SE BUSCA LA VIDA PARA SACAR LA IMPLEMENTACION A PARTIR DEL NOMBRE DEL METODO,
//O SI LA CONSULTA ES COMPLEJA, SE LA ESPECIFICAMOS NOSOTROS mediante anotacion @query y
//uso de nomenclatura HSQL :

//@Query("FROM Book p WHERE p.genre.name = :name")
//Optional<Book> findByGenreName(String name);

//1er paso: Maven dependency:
//<dependency>
//  <groupId>org.springframework.boot</groupId>
//  <artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>

//2o paso: Define a JPA Entity (que será un POJO) -> annotated as a JPA entity
// --> Se requirere un "default constructor" -> it exists only for the sake of JPA.
//The other constructor is the one you use to create instances of Customer to be 
//saved to the database.

//3er paso: el Repository:
//BookRepository extends the CrudRepository interface. The type of entity and ID 
//that it works with, Book and Long, are specified in the generic parameters on 
//CrudRepository. By extending CrudRepository, BookRepository inherits several 
//methods for working with Book persistence, including methods for saving, deleting, 
//and finding Customer entities:
//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

//Spring Data JPA also lets you define other query methods by declaring their method signature. 
//For example, CustomerRepository includes the findByTitle() method.
//In a typical Java application, you might expect to write a class that implements CustomerRepository. 
//However, that is what makes Spring Data JPA so powerful: You need not write an implementation of the 
//repository interface. Spring Data JPA creates an implementation when you run the application.


//By default, Spring Boot enables JPA repository support and looks in the package 
//(and its subpackages) where @SpringBootApplication is located. 

package daaw.bookapp.persistence.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import daaw.bookapp.persistence.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}