package com.cfs.JPA_P02.entity;

import jakarta.persistence.*;

@Entity
public class Laptop {

    // Primary key of Laptop table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Laptop model name (Dell, HP, MacBook etc.)
    private String model;

    /*
     * Owning side of One-to-One relationship
     *
     * Laptop owns the relationship
     * → foreign key exists in LAPTOP table
     *
     * student_id
     * → references Student.id
     *
     * unique = true
     * → ensures one laptop belongs to only one student
     */
    @OneToOne
    @JoinColumn(name ="student_id", unique = true)
    private Student student;
}
