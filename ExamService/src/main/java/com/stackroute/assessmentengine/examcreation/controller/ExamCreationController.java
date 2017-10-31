package com.stackroute.assessmentengine.examcreation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.stackroute.assessmentengine.examcreation.domian.Exam;
import com.stackroute.assessmentengine.examcreation.service.ExamCreationService;

@RestController
public class ExamCreationController 
{
	@Autowired
	ExamCreationService examCreationService;
	

	@RequestMapping(method=RequestMethod.POST, value="/create")
	public ResponseEntity<String> create(@RequestBody Exam exam)
	{
		examCreationService.create(exam);
		return ResponseEntity.ok("Exam saved Successfully");
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/gettwo/{subject}")
	public ResponseEntity<Exam> getExam(@PathVariable String subject)
	{
		return ResponseEntity.ok(examCreationService.findCustomBySubject(subject));
		
	}


}





