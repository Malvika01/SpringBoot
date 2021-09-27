package com.malvika.studentapi;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.malvika.studentapi.entities.Student;
import com.malvika.studentapi.repository.StudentRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
class StudentRestControllerMvctest {
	
	private static final String CONTEXT_URL = "/studentsapi";

	private static final String STUDENTS_URL = "/studentsapi/students/";

	private static final String PRODUCT_SUBJECT = "Maths";

	private static final String PRODUCT_NAME = "Malvika";

	private static final int PRODUCT_ID = 1;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private  StudentRepository repository;

	@Test
	void testFindAll() throws Exception {
		
		Student s = buildProduct();
		List<Student> students = new ArrayList<Student>();
		students.add(s);
	     when(repository.findAll()).thenReturn(students);
	     ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
	     mockMvc.perform(get(STUDENTS_URL).contextPath(CONTEXT_URL)).andExpect(status().isOk())
	     .andExpect(content().json(objectWriter.writeValueAsString(students)));
		
		
	}

	private Student buildProduct() {
		Student s = new Student();
		s.setId(PRODUCT_ID);
		s.setName(PRODUCT_NAME);
		s.setSubject(PRODUCT_SUBJECT);
		return s;
	}

}
