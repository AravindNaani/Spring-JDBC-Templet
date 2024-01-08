package com.springjdbc;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate jdbcTemplet = context.getBean("jdbctemplet",JdbcTemplate.class);
//		int Rows = jdbcTemplet.update("insert into student values(?,?,?)",5,"Aravind",80);
//		System.out.println(Rows);
		
//		int update = jdbcTemplet.update("update student set name=? where id=?","Aravi",5);
//		System.out.println(update);
		
//		jdbcTemplet.update("delete from student where id=?",5);
		

		RowMapper<Student> rowMapper = (rs,r)->{
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setMarks(rs.getInt(3));
			return student;
		};
		
//		List<Student> studentList = jdbcTemplet.query("select * from student", rowMapper);
//		studentList.stream().forEach((st)->System.out.println(st));
		
		Student student = jdbcTemplet.queryForObject("select * from student where id=1", rowMapper);
		System.out.println(student);
		
	}

}
