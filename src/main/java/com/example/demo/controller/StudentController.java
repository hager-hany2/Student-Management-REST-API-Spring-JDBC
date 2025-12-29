package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;



@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private  StudentRepo StudentRepo; 
	@GetMapping("/count")
	public int countStudent() {
	return StudentRepo.count();
			
    }
	@GetMapping("/{id}")
	public Student findById(@PathVariable("id") Long id) {
	    return StudentRepo.FindById(id);
	}
    
	@GetMapping("")
	public List<Student> findAll() {
		return StudentRepo.FindAll();
	}
	@PostMapping("/add")
	public String savetudent(@RequestBody Student stu) {
	    int rowsAffected = StudentRepo.insert(stu);
	    return rowsAffected > 0 ? "Student saved successfully!" : "Error saving Student";
	}
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Student stu) {
	    int rowsAffected = StudentRepo.update(stu);
	    return rowsAffected > 0 ? "Student updated successfully!" : "Student not found";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
	    int rowsAffected = StudentRepo.delete(id);
	    return rowsAffected > 0 ? "Student deleted successfully!" : "Student not found";
	}

}
