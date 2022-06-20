package com.example.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email taken"); //Test to check whether email Exist else save new student
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);

    if(!exists){

        throw new IllegalStateException(
                "student with id " + studentId + " does not exists");
    }

    studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

                if(name != null &&
                        name.length() > 0 &&
                        !Objects.equals(student.getName(), name )) {
                    student.setName(name);
                }

                if(email != null &&
                        email.length() > 0 &&
                        !Objects.equals(student.getEmail(), email )) {
                    Optional<Student> studentOptional = studentRepository
                            .findStudentByEmail(email);
                    if (studentOptional.isPresent()){
                        throw new IllegalStateException("Email is taken");
                    }
                    student.setEmail(email);
        }

    }
}

/*
List.of(
        new Student(
        1L,
        "Romel",
        "Romel.w@hotmail.co.uk",
        LocalDate.of(1997, Month.DECEMBER,5),
        24
        )
        ); */
