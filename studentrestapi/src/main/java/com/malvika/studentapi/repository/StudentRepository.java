package com.malvika.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malvika.studentapi.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
