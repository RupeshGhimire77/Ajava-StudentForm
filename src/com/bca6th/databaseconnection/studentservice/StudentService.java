package com.bca6th.databaseconnection.studentservice;

import java.util.List;

import com.bca6th.databaseconnection.studentmodel.Student;

public interface StudentService {
	public void saveStudent(Student student);
	public List<Student> getStudent();
	public List<Student> searchStudentByName(String name);
}
