package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Teacher;
import com.example.repository.TeacherRepositoryImp;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepositoryImp teacherRepositoryImp;
	
	public Teacher createTeacher(Teacher teacher) {
		return teacherRepositoryImp.createTeacher(teacher);
	}
	
	public Teacher findById(Long id) {
		return teacherRepositoryImp.findById(id);
	}
	
	public void deleteTecher(Long id) {
		teacherRepositoryImp.deleteTecher(id);
	}
	
	public Teacher updateTeacher(Teacher teacher) throws Exception {
		if(teacher.getId() != null && teacherRepositoryImp.findById(teacher.getId()) != null) {
			return teacherRepositoryImp.updateTeacher(teacher);			
		}
		throw new Exception();
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepositoryImp.findAll();
	}

}
