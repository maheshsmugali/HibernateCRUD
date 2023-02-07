package com.pws.springboothibernatecrud.service;

import com.pws.springboothibernatecrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements com.pws.springboothibernatecrud.service.StudentService {
    @Autowired
    private StudentRepository repository;
    @Override
    public Integer saveStudent(Student student) {
        return repository.save(student).getSno();
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student getAllStudentById(Integer sno) {
        return repository.findById(sno).get();
    }

    @Override
    public void deleteStudent(Integer sno) {
        repository.deleteById(sno);

    }

    @Override
    public Student getStudentById(Integer sno) {
        return repository.findById(sno).get();
    }
}