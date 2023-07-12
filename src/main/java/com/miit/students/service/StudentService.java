package com.miit.students.service;

import java.util.List;

import com.miit.students.models.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public Student updateStudent(Integer id, Student student);

	public Student getStudent(Integer id);

	public List<Student> getAllStudents();

	public Boolean deleteStudent(Integer id);

}
