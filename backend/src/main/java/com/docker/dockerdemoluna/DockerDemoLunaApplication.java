package com.docker.dockerdemoluna;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerDemoLunaApplication {

	private static final Logger log = LoggerFactory.getLogger(DockerDemoLunaApplication.class);

	public static void main(String[] args) {
		System.out.println(" Hello, Luna ");
		SpringApplication.run(DockerDemoLunaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository studentRepository) {
		return (args) -> {
			// SetUp studentRepository
			studentRepository.save(new Student(1L,"Luna"));
			studentRepository.save(new Student(2L, "Yue Zhang"));
			studentRepository.save(new Student(3L, "lzhang"));
			studentRepository.save(new Student(4L, "Luna Zhang"));

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
