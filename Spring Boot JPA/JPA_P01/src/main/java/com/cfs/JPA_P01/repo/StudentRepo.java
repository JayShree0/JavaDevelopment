package com.cfs.JPA_P01.repo;

import com.cfs.JPA_P01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}

