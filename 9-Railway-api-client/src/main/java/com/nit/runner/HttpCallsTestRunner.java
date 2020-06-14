package com.nit.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nit.model.Student;

@Component
public class HttpCallsTestRunner 
	implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--welcome to consumer app--");
		
		//--------- FETCH ONE ROW--------------
	
		String url="http://localhost:9092/student/one/10";
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Student> resp=rt.getForEntity(url, Student.class);
		
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode().name());
		System.out.println(resp.getStatusCodeValue());
		
		
		//---FETCH ALL ROWS----------------------
		/*
		 * String url="http://localhost:9092/student/all";
		 * 
		 * RestTemplate rt=new RestTemplate(); ResponseEntity<Student[]>
		 * resp=rt.getForEntity(url, Student[].class);
		 * 
		 * Student[] arr=resp.getBody(); // Convert Array back to List List<Student>
		 * list=Arrays.asList(arr); for(Student s:list) { System.out.println(s); }
		 * 
		 * System.out.println(resp.getStatusCode().name());
		 * System.out.println(resp.getStatusCodeValue());
		 */		
		System.exit(0); //stop server 
	}
}