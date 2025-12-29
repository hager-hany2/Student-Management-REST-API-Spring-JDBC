package com.example.demo.repositry.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
@Repository
public class StudentJDBCRepo implements StudentRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from student", Integer.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student FindById(Long id) {
		return jdbcTemplate.queryForObject("SELECT id, name, email, age FROM student WHERE id = ?"
				+ "",new Object[] {id} 
		, new StudentMapper()
				
				);
	}

	
	@Override
	public List<Student> FindAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from student"
		, new StudentMapper()
				
		);
	}

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
//		return jdbcTemplate.update("INSERT INTO student (id,name,email,age) VALUES (?, ?,?,?);",
//				new Object[] {student.getId(),student.getName(),student.getEmail(),student.getAge()});
		return jdbcTemplate.update(
			    "INSERT INTO student (name, email, age) VALUES (?, ?, ?)",
			    new Object[] { student.getName(), student.getEmail(), student.getAge() }
			);

	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
	    return jdbcTemplate.update(
	            "update student set name=?, email=?, age=? where id=?",
	            student.getName(), student.getEmail(), student.getAge(), student.getId()
	        );
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from student where id=?;",
				new Object[] {id});
	}

}
