package com.pws.springboothibernatecrud.service;

import com.pws.springboothibernatecrud.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
