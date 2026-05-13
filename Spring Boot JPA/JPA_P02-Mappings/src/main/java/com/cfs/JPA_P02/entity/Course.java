package com.cfs.JPA_P02.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    // Primary key of Course table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Course name (Java, Spring, SQL etc.)
    private String name;

    /*
     * Inverse side of Many-to-Many relationship
     *
     * mappedBy = "course"
     * → mapping is controlled by Student entity
     * → no join table defined here
     */
    @ManyToMany(mappedBy = "course")
    private List<Student> students;
}
