package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
