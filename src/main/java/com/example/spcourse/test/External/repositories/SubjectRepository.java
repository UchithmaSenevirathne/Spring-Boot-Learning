package com.example.spcourse.test.External.repositories;


import com.example.spcourse.test.Domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findByName(String name);

//    @Query(value = "select * from student where email = ?1", nativeQuery = true)
//    List<Student> findByEmail(Integer email);

}
