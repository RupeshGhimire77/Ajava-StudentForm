package com.bca6th.databaseconnection.studentservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bca6th.databaseconnection.connectionsetup.DatabaseConnection;
import com.bca6th.databaseconnection.studentmodel.Student;

public class StudentServiceImpl implements StudentService{

	PreparedStatement ps=null;
	
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			String sql="Insert into student(name,address,contact,gender ,section, subject)Values(?,?,?,?,?,?)";
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setLong(3, student.getContact());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getSection());
			ps.setString(6, student.getSubject());
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<Student> getStudent() {
		List<Student> studentList = new ArrayList<>();
		String sql ="Select * from student";
		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAddress(rs.getString("address"));
			student.setContact(rs.getLong("contact"));
			student.setGender(rs.getString("gender"));
			student.setSection(rs.getString("section"));
			student.setSubject(rs.getString("subject"));
			studentList.add(student);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	@Override
	public List<Student> searchStudentByName(String name) {
		List<Student> studentList = new ArrayList<>();
		String sql ="Select * from student where name like ?";
		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAddress(rs.getString("address"));
			student.setContact(rs.getLong("contact"));
			student.setGender(rs.getString("gender"));
			student.setSection(rs.getString("section"));
			student.setSubject(rs.getString("subject"));
			studentList.add(student);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

}
