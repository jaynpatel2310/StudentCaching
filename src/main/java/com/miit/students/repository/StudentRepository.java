package com.miit.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.miit.students.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("update Student s set s.first_name=?2, s.last_name= ?3 where s.id=?1")
	@Modifying
	default void updateStudent(Integer id, String firstName, String lastName) {
	}

}
