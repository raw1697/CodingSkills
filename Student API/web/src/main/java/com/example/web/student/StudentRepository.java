package com.example.web.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// access to database
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //SELECT * FROM student WHERE email = ?
    //Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
