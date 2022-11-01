package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Teacher;
import com.example.service.TeacherService;

@RestController
@CrossOrigin("*")
@RequestMapping
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/teachers")
	public ResponseEntity<Map<String, Object>> getAllTeachers() {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("teachers", teacherService.getAllTeachers());
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de obtener todos los profesores");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping("/teachers/{id}")
	public ResponseEntity<Map<String, Object>> getTeacherById(@PathVariable("id") Long id) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("teacher", teacherService.findById(id));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de obtener el profesor por id");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping("/teachers")
	public ResponseEntity<Map<String, Object>> createTeacher(@RequestBody Teacher teacher) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("teacher", teacherService.createTeacher(teacher));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de crear al profesor");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@PutMapping("/teachers")
	public ResponseEntity<Map<String, Object>> updateTeacher(@RequestBody Teacher teacher) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("teacher", teacherService.updateTeacher(teacher));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de actualizar al profesor");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<Map<String, Object>> deleteTeacher(@PathVariable("id") Long id) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			teacherService.deleteTecher(id);
			mapResponse.put("teacher", "Teacher Deleted");
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de borrar al profesor");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
}
