package com.malvika.studentapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malvika.studentapi.entities.Student;
import com.malvika.studentapi.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentrepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public List<Student> getStudentDetails() {
		return studentrepo.findAll();
	}
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.GET)
	@Transactional
	@Cacheable("student-cache")
	public Student getStudentDetail(@PathVariable int id) {
		LOGGER.info("finding ID " + id);
		return studentrepo.findById(id).get();
	}
	
	@RequestMapping(value="/students/", method = RequestMethod.POST)
	public Student createStudentDetail(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	
	@RequestMapping(value="/students/", method = RequestMethod.PUT)
	public Student updateStudentDetail(@Valid @RequestBody Student student) {
		return studentrepo.save(student);
	}
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public Student deleteStudentDetail(@PathVariable int id) {
		return studentrepo.findById(id).get();
	}
	
	

}
