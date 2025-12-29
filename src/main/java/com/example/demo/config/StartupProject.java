package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
@Component

public class StartupProject implements CommandLineRunner{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRepo studentrepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stubs
		jdbcTemplate.execute("DROP TABLE IF EXISTS student;");
		jdbcTemplate.execute("CREATE TABLE student(id SERIAL  ,name varchar(45),email varchar(100),age Integer)");
		if(studentrepo.count() == 0) {
			studentrepo.insert(new Student(1L,"hager","hagerhanyahmedali@gmail.com",21));
			studentrepo.insert(new Student(2L,"hany","hanyahmedali@gmail.com",40));
			studentrepo.insert(new Student(3L,"safaa","safaahanyahmedali@gmail.com",18));
			studentrepo.insert(new Student(4L,"body","bodyhanyahmedali@gmail.com",16));
			studentrepo.insert(new Student(5L,"hala","halaselim@gmail.com",35));
		}

		
		
	}

}
