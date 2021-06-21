package com.docker.dockerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DockerDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository studentRepository) {
		return (args) -> {
			// SetUp studentRepository
			studentRepository.save(new Student(1L,"Test Student1"));
			studentRepository.save(new Student(2L,"Test Student2"));
			studentRepository.save(new Student(3L,"Test Student3"));
			studentRepository.save(new Student(4L,"Test Student4"));

			// fetch all Student
			log.info("Student found with findAll():");
			log.info("-------------------------------");
			studentRepository.findAll().stream().map(Student::toString).forEach(log::info);
			log.info("");

			// fetch an individual Student by ID
			Student student = studentRepository.findById(1L).orElse(null);
			log.info("Student found with findById(1L):");
			log.info("--------------------------------");
			log.info(student.toString());
			log.info("~~~~~~Test finish~~~~~");
		} ;
	}

}
