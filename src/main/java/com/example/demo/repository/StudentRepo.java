package com.example.demo.repository;
import java.util.List;

import com.example.demo.model.Student;
public interface StudentRepo {
//	count
	int count();
//	find by id
	Student FindById(Long id);
//	find all data
	List<Student> FindAll();
//	insert data ===>save
	int insert(Student student); 
//	update data
	int update(Student student); 
//	delete data
	int delete(Long id); 

}
