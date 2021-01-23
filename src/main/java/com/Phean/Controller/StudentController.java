package com.Phean.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.Phean.Models.Student;
import com.Phean.Services.studentService;

@RestController
public class StudentController {
	studentService st=new studentService();
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="api/v1",method=RequestMethod.GET)
	public List<Student> getStudent() {
		return st.getList();
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="api/v1/insertStudent",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Student insertStudent(@RequestBody Student s)
	{
		return st.insertStudent(s);
	}

//	Implement put Delete ....
}
