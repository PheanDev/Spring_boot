package com.Phean.Services;

import com.Phean.Models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class studentService implements com.Phean.Dao.studentDao {

   Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

   SessionFactory sf = con.buildSessionFactory();
   Session session = sf.openSession();
   Transaction tran;

   private List<Student> lstStudent = new ArrayList<Student>();

   @Override
   public List<Student> getList() {
      Student st = new Student();
      st.setId(101);
      st.setName("Phean");
      st.setGender("Male");
      st.setAge("20");
      st.setScore("100");
      lstStudent.add(st);
      return lstStudent;
   }

   @Override
   public Student insertStudent(Student json) {
      try {
         tran= session.beginTransaction();
         Student st = new Student();
         st.setId(json.getId());
         st.setName(json.getName());
         st.setGender(json.getGender());
         st.setAge(json.getAge());
         st.setScore(json.getScore());
         session.save(st);
         tran.commit();
         return json;
      } catch (Exception ex) {

         System.out.print(ex.getMessage());
         return new Student();
      }
   }

}
