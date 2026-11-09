package com.StudentManagementSystem.controller;

import com.StudentManagementSystem.model.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        Student student = repository.findById(id).orElse(null);

        if (student != null) {
            student.setName(newStudent.getName());
            student.setMajor(newStudent.getMajor());
            student.setGrade(newStudent.getGrade());
            return repository.save(student);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }
}