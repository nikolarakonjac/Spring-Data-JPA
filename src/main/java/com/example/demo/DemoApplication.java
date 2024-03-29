package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository studentRepository,
			CompanyRepository companyRepository
			){

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

			Company company = new Company(
					UUID.randomUUID(),
					"1234567890123",
					"12345678901234567890",
					"Beograd"
			);

			companyRepository.save(company);


		};
	}

}
