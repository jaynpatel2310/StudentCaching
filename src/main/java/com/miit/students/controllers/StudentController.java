package com.miit.students.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miit.students.models.Student;
import com.miit.students.service.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("/")
	public List<Student> getAllStudent() {
		return studentServiceImpl.getAllStudents();
	}

	@PostMapping("/")
	public Student addStudent(@Valid @RequestBody Student student) {
		System.out.println(student);
		return studentServiceImpl.addStudent(student);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentServiceImpl.getStudent(id);
	}

	@DeleteMapping("/{id}")
	public Boolean deleteStudent(@PathVariable Integer id) {
		return studentServiceImpl.deleteStudent(id);
	}

	@PostMapping("/{id}")
	public Student updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
		return studentServiceImpl.updateStudent(id, student);
	}

}
