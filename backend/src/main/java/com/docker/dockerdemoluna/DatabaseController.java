package com.docker.dockerdemoluna;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/database")
public class DatabaseController {

    private final StudentService studentService;

    public DatabaseController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String DatabaseConnectTest() {
        System.out.println("~Hello, Student Backend Test~");
        return "Hello, I am health! These are all Student List: " + studentService.getAllStudents();
    }

}
