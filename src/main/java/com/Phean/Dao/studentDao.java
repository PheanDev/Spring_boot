package com.Phean.Dao;

import com.Phean.Models.Student;
import java.util.List;

public interface studentDao {
    public List<Student> getList();
    public Student insertStudent(Student json);

    // Add more CRUD here ......
}