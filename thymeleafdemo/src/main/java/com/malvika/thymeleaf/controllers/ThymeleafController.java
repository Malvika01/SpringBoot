package com.malvika.thymeleaf.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.malvika.thymeleaf.model.Student;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/hello")
	public String welcome() {
		return "hello";
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		
		ModelAndView mvc = new ModelAndView("data");
		mvc.addObject("message", "Learn and grow");
		return mvc;
		
	}
	
	@RequestMapping("/student")
	public ModelAndView studentDetails() {
		ModelAndView mv = new ModelAndView("student");
		Student s = new Student();
		s.setName("Malvika");
		s.setRoll(24);
		mv.addObject("student", s);
		return mv;
	}
	
	@RequestMapping("/students")
	public ModelAndView studentDetailsList() {
		ModelAndView mv = new ModelAndView("studentinfo");
		Student s = new Student();
		s.setName("A");
		s.setRoll(01);
		Student s2 = new Student();
		s2.setName("B");
		s2.setRoll(02);
		List<Student> studentsDetails = Arrays.asList(s,s2);
		mv.addObject("students", studentsDetails);
		return mv;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView getstudentForm() {
		ModelAndView mv = new ModelAndView("studentform");
		Student s = new Student();
		s.setName("A");
		s.setRoll(01);
		mv.addObject("student", s);
		return mv;
	}
	
	@RequestMapping("/studentFormSubmittion")
	public ModelAndView submitstudentForm(@ModelAttribute Student student) {
		ModelAndView mv = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getName());
		return mv;
	}
}
