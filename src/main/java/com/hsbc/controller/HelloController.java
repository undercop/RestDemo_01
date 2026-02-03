package com.hsbc.controller;

import com.hsbc.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHelloGet(){
        return "hell by get" ;
    }

    @PostMapping
    public String sayHelloPost(){
        return "helloo by postt";
    }

    @GetMapping("/{x}/{y}")
    public String sayHelloName(@PathVariable("x") String name , @PathVariable("y") String tech){
        return "Hello"+ name +" working in " + tech;
    }
    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student);
        return "saved successfully";
    }
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(101 , "sagar" , "sagar@gmail");
        return student;
    }
}
