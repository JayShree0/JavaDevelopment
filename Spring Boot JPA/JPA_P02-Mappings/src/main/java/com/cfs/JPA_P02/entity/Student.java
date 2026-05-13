package com.cfs.JPA_P02.entity;

import jakarta.persistence.*;

@Entity // Marks this class as a JPA entity (table = student)
public class Student {

    // ================= PRIMARY KEY =================

    // Primary key of Student table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Simple column for student name
    private String name;

    // ================= ONE TO ONE =================

    /*
     * Inverse side of One-to-One relationship
     *
     * mappedBy = "student"
     * → tells Hibernate that Laptop entity owns this relationship
     * → foreign key is present in Laptop table, NOT here
     *
     * cascade = CascadeType.ALL
     * → any operation on Student will cascade to Laptop
     *   save student  → save laptop
     *   delete student → delete laptop
     */
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    // ================= MANY TO ONE =================

    /*
     * Many students can belong to ONE teacher
     *
     * fetch = FetchType.LAZY
     * → Teacher data will NOT be loaded immediately
     * → Loaded only when student.getTeacher() is accessed
     *
     * @JoinColumn(name = "teacher_id")
     * → foreign key column in STUDENT table
     * → refers to Teacher.id
     *
     * ❌ unique = true is WRONG for ManyToOne
     *    because multiple students can have same teacher
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // ================= MANY TO MANY =================

    /*
     * Many students can enroll in many courses
     *
     * @JoinTable creates a third table (student_course)
     *
     * joinColumns
     * → foreign key referencing Student table
     *
     * inverseJoinColumns
     * → foreign key referencing Course table
     */
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Course course;

    // ================= CONSTRUCTORS =================

    // Required by JPA (MANDATORY)
    public Student() {}

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters & setters
}
