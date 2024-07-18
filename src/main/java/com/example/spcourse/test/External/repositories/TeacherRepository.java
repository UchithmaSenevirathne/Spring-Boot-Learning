package com.example.spcourse.test.External.repositories;

import com.example.spcourse.test.Domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByName(String name);

//    @Query(value = "select * from student where email = ?1", nativeQuery = true)
//    List<Student> findByEmail(Integer email);

}
