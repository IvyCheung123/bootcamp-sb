package com.bootcamp.sb.sb_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import java.util.List;

// Bean need to create on Class, not Interface
// Hibernate = JPA (Java): can one-to-many
// 1. During compile time, generate Class to implement this Interface
// 2. Implement all the method according to the DB driver
// 3. Construct the corresponding Entity Java object
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // Long -> must follow primary key datatype Long

  // save() -> Hibernate will automatically write the syntax based on .yml -> INSERT INTO Users VALUE (...);
  //        -> similar to Map.put -> create or update
  // saveAll(userEntity) -> many insert into (given List<UserEntity>)

  // findAll() -> select * from Users; -> DB return List<User> to Java
  // findById() -> select * from Users where id = xxx -> locate Long

  // deleteById()

  // count() -> count 1

  // select * from Users where name = xxx
  List<UserEntity> findByName(String name);

  // select * from Users where name = xxx and website = yyy
  List<UserEntity> findByNameAndWebsite(String name, String website);
  // -> findAll() -> filter() in Java

  // select * from Users where name = xxx or website = yyy
  List<UserEntity> findByNameOrWebsite(String name, String website); // from Entity

  // // By default, use attribute_name from Entity (Wrong, not complete)
  // @Query("SELECT '*' FROM PostEntity WHERE PostEntity.id > 2")
  // List<PostEntity> findIdBiggerThanTwo();

  // nativeQuery -> use column_name from Database
  @Query(value = "SELECT '*' FROM Posts WHERE Posts.postID > 2", nativeQuery = true)
  List<PostEntity> findPostIDBiggerThanTwo();
}
