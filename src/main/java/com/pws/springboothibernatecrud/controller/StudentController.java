package com.pws.springboothibernatecrud.controller;

import com.pws.springboothibernatecrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {
    @Autowired
    private com.pws.springboothibernatecrud.service.StudentService service;

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        Integer id = service.saveStudent(student);
        return new ResponseEntity<>("Student with " + id + " has been saved ", HttpStatus.OK);

    }

    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> getAllStudentDetails() {
        List<Student> List = service.getAllStudents();
        return new ResponseEntity<List<Student>>(List, HttpStatus.OK);
    }

    @GetMapping("/studentById/{sno}")
    public ResponseEntity<Student> grtStudentById(@PathVariable("sno") Integer sno) {
        Student std = service.getAllStudentById(sno);
        return new ResponseEntity<Student>(std, HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent( @RequestBody Student student) {
        Student stdFromDb = service.getStudentById(student.getSno());
        stdFromDb.setStdName(student.getStdName());
        stdFromDb.setSchoolName(student.getSchoolName());
        stdFromDb.setStdClass(student.getStdClass());
        Integer id = service.saveStudent(stdFromDb);
        return new ResponseEntity<String>("Student " + id + " has been updated", HttpStatus.OK);

    }
    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteSudent(@RequestParam Integer sno){
        service.deleteStudent(sno);
        return new ResponseEntity<String>("Student with "+sno+"has been deleted",HttpStatus.OK);
    }
}
