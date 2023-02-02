package com.example.demo.course;

import com.example.demo.course.Course;
import com.example.demo.course.jdbc.CourseJdbcRepository;
import com.example.demo.course.jpa.CourseJpaRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Spring Jpa", "Josh Long"));
        repository.insert(new Course(2, "Javascript Jpa", "Tamerlan"));
        repository.insert(new Course(3, "Army Air Jpa", "Ariz"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
