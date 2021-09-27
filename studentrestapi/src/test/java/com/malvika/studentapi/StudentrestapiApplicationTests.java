package com.malvika.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.malvika.studentapi.entities.Student;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;;

@SpringBootTest
class StudentrestapiApplicationTests {
	
	@Value("${studentrestapi.services.url}")
	private String baseUrl;
	
	RestTemplate resttemplate = new RestTemplate();

	
	
	@Test
	void testGetStudentDetails() {
		System.out.println(baseUrl);
		Student student = resttemplate.getForObject(baseUrl+"2", Student.class);
		assertNotNull(student);
		assertEquals("B", student.getName());
	}
	
	
	
	@Test
	void testUpdateStudentDetails() {

		
		Student student2 = resttemplate.getForObject(baseUrl+"4", Student.class);
		student2.setSubject("GK");
		resttemplate.postForObject(baseUrl, student2,Student.class);
		
	}
}
