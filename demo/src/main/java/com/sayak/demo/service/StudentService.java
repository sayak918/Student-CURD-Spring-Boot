package com.sayak.demo.service;

import com.sayak.demo.dao.StudentDao;
import com.sayak.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public Student findById(Integer id) {
       return studentDao.findById(id).get();
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }
}
