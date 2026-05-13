package com.cfs.Student.controller;

import com.cfs.Student.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    // 
    // In-Memory Database (Temporary Storage)
    // Key   -> Student ID (Long)
    // Value -> Student Object
    // 
    private Map<Long, Student> studentDb = new HashMap<>();


    // 
    // GET ALL STUDENTS
    // URL: GET /students
    // 
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> students = new ArrayList<>(studentDb.values());
        return ResponseEntity.ok(students);
    }


    // 
    // GET STUDENT BY ID
    // URL: GET /students/{id}
    // 
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        Student student = studentDb.get(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(student);
    }


    // 
    // ADD NEW STUDENT
    // URL: POST /students
    // 
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        studentDb.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }


    // 
    // UPDATE STUDENT (FULL UPDATE)
    // URL: PUT /students/{id}
    // 
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        if (!studentDb.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Ensure path ID is used
        student.setId(id);
        studentDb.put(id, student);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    // 
    // UPDATE STUDENT (PARTIAL UPDATE)
    // URL: PATCH /students/{id}
    // 
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateStudentPartially(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student existing = studentDb.get(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (student.getName() != null) {
            existing.setName(student.getName());
        }

        if (student.getEmail() != null) {
            existing.setEmail(student.getEmail());
        }

        if (student.getAge() != null) {
            existing.setAge(student.getAge());
        }

        studentDb.put(id, existing);
        return ResponseEntity.ok("Student updated partially");
    }


    // 
    // DELETE STUDENT
    // URL: DELETE /students/{id}
    // 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        if (!studentDb.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        studentDb.remove(id);
        return ResponseEntity.ok("Student data deleted successfully");
    }
}
