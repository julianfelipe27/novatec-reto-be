package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentRepositoryImp {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> findAll() {
		return (ArrayList<Student>)studentRepository.findAll();
	}
}
