package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepositoryImp;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepositoryImp studentRepositoryImp;

	public Student createStudent(Student student) {
		return studentRepositoryImp.createStudent(student);
	}
	
	public Student findById(Long id) {
		return studentRepositoryImp.findById(id);
	}
	
	public void deleteStudent(Long id) {
		studentRepositoryImp.deleteStudent(id);;
	}
	
	public Student updateStudent(Student student) throws Exception {
		if(student.getId() != null && studentRepositoryImp.findById(student.getId()) != null) {
			return studentRepositoryImp.updateStudent(student);
		}
		throw new Exception();
	}
	
	public List<Student> findAllStudents() {
		return studentRepositoryImp.findAll();
	}
}
