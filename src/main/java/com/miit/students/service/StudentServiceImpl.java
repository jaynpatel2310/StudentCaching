package com.miit.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.miit.students.models.Student;
import com.miit.students.repository.StudentRepository;

@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@CachePut(key = "#id")
	public Student updateStudent(Integer id, Student student) {
		addStudent(student);
		return getStudent(id);
	}

	@Override
	@Cacheable(key = "#id")
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).orElse(new Student());
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	@CacheEvict(key = "#id")
	public Boolean deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return true;
	}

}
