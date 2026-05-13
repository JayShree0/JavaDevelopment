package com.cfs.JPA_P02.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    // Primary key of Teacher table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Teacher name
    private String name;

    /*
     * One teacher can have many students
     *
     * mappedBy = "teacher"
     * → Student entity owns the relationship
     * → foreign key exists in STUDENT table
     */
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
}
