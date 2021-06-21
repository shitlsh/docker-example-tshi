package com.docker.dockerdemoluna;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/health")
public class HealthController {

    @GetMapping
    public String Health(){
        return "Hello, I am health! ";
    }

}

