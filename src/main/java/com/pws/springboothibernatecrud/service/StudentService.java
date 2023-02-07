package com.pws.springboothibernatecrud.service;

import com.pws.springboothibernatecrud.entity.Student;

import java.util.List;

public interface StudentService {
    public Integer saveStudent(Student student);

    public List<Student> getAllStudents();
    public Student getAllStudentById(Integer sno);

    public void  deleteStudent(Integer sno);

    Student getStudentById(Integer sno);
}
