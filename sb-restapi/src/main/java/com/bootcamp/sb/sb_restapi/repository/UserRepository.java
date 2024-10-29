package com.bootcamp.sb.sb_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import java.util.List;

// Bean need to create on Class, not Interface
// Hibernate = JPA (in Java): can one-to-many
// 1. During compile time, generate Class to implement this Interface
// 2. Implement all the method according to the DB driver
// 3. Construct the corresponding Entity Java object
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // Long -> must follow primary key datatype Long

  // JPA Methods: use method name to communicate with hibernate

  // 1. Built-in JPA Methods

  // save() -> Hibernate will automatically write the syntax based on .yml -> INSERT INTO Users VALUE (...);
  //        -> similar to Map.put -> create or update
  // saveAll(userEntity) -> many insert into (given List<UserEntity>)

  // findAll() -> select * from Users; -> DB return List<User> to Java
  // findById() -> select * from Users where id = xxx -> locate Long

  // deleteById()

  // count() -> count 1

  // 2. Custom JPA Methods
  // Adv: do not need to follow DBMS syntax, can use Oracle, MySQL, PSQL, etc.

  // select * from Users where name = xxx
  List<UserEntity> findByName(String name);

  // select * from Users where name = xxx and website = yyy
  List<UserEntity> findByNameAndWebsite(String name, String website);
  // -> findAll() -> filter() in Java

  // select * from Users where name = xxx or website = yyy
  List<UserEntity> findByNameOrWebsite(String name, String website); // from Entity

  // 3. JPQL: role between SQL and JPA
  // - Syntax is similar to SQL
  // - Select from Entity
  // - Support AND, OR, ORDER BY, INNER JOIN, LEFT JOIN, AVG(), MAX(), etc

  // // By default, use attribute_name from Entity (Wrong, not complete)
  // @Query("SELECT '*' FROM PostEntity WHERE PostEntity.id > 2")
  // List<PostEntity> findIdBiggerThanTwo();

  // username -> Entity's attribute_name
  @Query("SELECT e FROM UserEntity e WHERE e.username = :username")
  UserEntity findByUsername(@Param("username") String username);
  // try ...

  @Query("SELECT e FROM UserEntity e WHERE e.username = :username ORDER BY e.website")
  UserEntity findByUsernameOrderByWebsiteDesc(@Param("username") String username);

  // 4. nativeQuery -> use column_name from Database
  // Disadv: product specific

  @Query(value = "SELECT '*' FROM Posts WHERE Posts.postID > 2", nativeQuery = true)
  List<PostEntity> findPostIDBiggerThanTwo();

  // more than two fields (query, nativeQuery = true) -> use value =
  // username -> column_name
  @Query(value = "SELECT * FROM Users u WHERE u.username = :username", nativeQuery = true)
  UserEntity findByUsername2(@Param("username") String username);

  // For all write operation, use @Modifying -> put the changes into database, not just memory
  @Modifying
  @Query(value = "UPDATE Users SET useremail = :userEmail WHERE id = :id", nativeQuery = true)
  int updateUseremail(@Param("userEmail") String userEmail, @Param("id") Long id);
}
