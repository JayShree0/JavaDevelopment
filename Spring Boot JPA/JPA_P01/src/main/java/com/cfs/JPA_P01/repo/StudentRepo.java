package com.cfs.JPA_P01.repo;

import com.cfs.JPA_P01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// repo kiska liye bna rhe hai aur uske primary key kya hai...
public interface StudentRepo extends JpaRepository<Student, Long> {
}

