package com.cfs.JPA_P01.controller;

import com.cfs.JPA_P01.entity.Student;
import com.cfs.JPA_P01.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Sirf ek variable hai, aur constructor injection use ho raha hai.
    // Is case me @Autowired lagana JARURI nahi hota.
    // Spring 4.3+ automatically detect karke dependency inject kar deta hai.
    private final StudentRepo studentRepo;

    // Constructor Injection
    public StudentController(StudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student)
    {
     Student s = studentRepo.findById(id)
             .orElseThrow(() -> new RuntimeException("Student Not Found"));
     s.setName(student.getName());
     s.setEmail(student.getEmail());
     return studentRepo.save(s);
    }


    @PatchMapping
    public Student patchStudent(@RequestParam Long id, @RequestParam String name)
    {
        Student s = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
        s.setName(name);
        return studentRepo.save(s);
    }

//    @PatchMapping("/students/{id}") // Recommended to put the ID in the path
//    public Student patchStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
//
//        // 1. Fetch the existing student or throw an exception
//        Student existingStudent = studentRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student Not Found with ID: " + id));
//
//        // 2. Apply PATCH logic: ONLY update fields that are NOT null in the request body (studentDetails)
//
//        // Update Name
//        if (studentDetails.getName() != null) {
//            existingStudent.setName(studentDetails.getName());
//        }
//
//        // Update Email
//        if (studentDetails.getEmail() != null) {
//            existingStudent.setEmail(studentDetails.getEmail());
//        }
//
//        // You would add similar checks for any other fields (e.g., studentDetails.getMajor() != null)
//
//        // 3. Save and return the updated entity
//        return studentRepo.save(existingStudent);
//    }


}
