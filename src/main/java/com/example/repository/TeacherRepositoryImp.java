package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Teacher;

@Repository
public class TeacherRepositoryImp {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public Teacher createTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public Teacher findById(Long id) {
		return teacherRepository.findById(id).orElse(null);
	}
	
	public void deleteTecher(Long id) {
		teacherRepository.deleteById(id);
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public List<Teacher> findAll() {
		return (ArrayList<Teacher>)teacherRepository.findAll();
	}
}
