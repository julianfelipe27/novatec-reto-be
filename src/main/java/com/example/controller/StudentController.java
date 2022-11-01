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

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<Map<String, Object>> getAllStudents() {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("students", studentService.findAllStudents());
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de obtener todos los estudiantes");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable("id") Long id) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("student", studentService.findById(id));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de obtener el estudiante por id");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Map<String, Object>> createStudent(@RequestBody Student student) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("student", studentService.createStudent(student));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de crear al estudiante");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Map<String, Object>> updateStudent(@RequestBody Student student) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			mapResponse.put("student", studentService.updateStudent(student));
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de actualizar al estudiante");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable("id") Long id) {
		Map<String, Object> mapResponse = new HashMap<>();
		try {
			studentService.deleteStudent(id);
			mapResponse.put("student", "Student Deleted");
		} catch (Exception e) {
			mapResponse.put("error", "Error al tratar de borrar al estudiante");
			return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
	}
}
