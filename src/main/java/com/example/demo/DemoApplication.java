package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student nikola = new Student(
					"nikola",
					"rakonjac",
					"nikola@gmail.com",
					22
			);
			studentRepository.save(nikola);


			Student pronadjenStudent = studentRepository.findByFirstName("nikola");

			if(pronadjenStudent != null){
				System.out.println(pronadjenStudent);
			}
			else{
				System.out.println("User not found.");
			}


		};
	}

}
