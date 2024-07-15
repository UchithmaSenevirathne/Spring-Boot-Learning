package com.example.spcourse.test.External.repositories;

import com.example.spcourse.test.Domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //JPQL query methods
    Optional<Student> findByName(String name);

    //custom queries
//    List<Student> findByEmail(List<Integer> email);

    //native queries
//    1 is first parameter of second line
    @Query(value = "select * from student where email = ?1", nativeQuery = true)
    List<Student> findByEmail(Integer email);  //2 line

}
