package com.example.web.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository){

        return args -> {
            Student romel = new Student(
                            1L,
                            "Romel",
                            "Romel.w@hotmail.co.uk",
                            LocalDate.of(1997, Month.DECEMBER,5)
            );

            Student pagie = new Student(
                    1L,
                    "Pagie",
                    "Romel.w@hotmail.co.uk",
                    LocalDate.of(1997, Month.DECEMBER,5)
            );

            repository.saveAll(
                    List.of(romel,pagie)
            );
        };
    }
}
