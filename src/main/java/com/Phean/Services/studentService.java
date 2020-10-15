package com.Phean.Services;

import java.util.List;

import com.Phean.Models.Student;

public interface studentService {
   public List<Student> getList();
   public Student insertStudent(Student json);
}
