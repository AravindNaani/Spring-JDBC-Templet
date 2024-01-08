package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate jdbcTemplet = context.getBean("jdbctemplet",JdbcTemplate.class);
//		int Rows = jdbcTemplet.update("insert into student values(?,?,?)",5,"Aravind",80);
//		System.out.println(Rows);
		
//		int update = jdbcTemplet.update("update student set name=? where id=?","Aravi",5);
//		System.out.println(update);
		
		jdbcTemplet.update("delete from student where id=?",5);
	}

}
