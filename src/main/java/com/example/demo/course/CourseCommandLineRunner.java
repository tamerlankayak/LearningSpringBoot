package com.example.demo.course;

import com.example.demo.course.Course;
import com.example.demo.course.jdbc.CourseJdbcRepository;
import com.example.demo.course.jpa.CourseJpaRepository;
import com.example.demo.course.springdatajpa.CourseSpringDataJpaRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn Spring Jpa", "Josh Long"));
        repository.save(new Course(2, "Javascript Jpa", "Tamerlan"));
        repository.save(new Course(3, "Army Air Jpa", "Ariz"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Ariz"));
        System.out.println(repository.findByName("Army Air Jpa"));
    }
}
