package com.desamsettih.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
@Controller
public class StudentController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}

	
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		
		//Create a student object
		Student theStudent = new Student();
		
		//Add the student object to the model
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult)
	{
		System.out.println("theStudent : "+theStudent.getFirstName()+" "+theStudent.getLastName()+" "+theStudent.getCountry());
		if(theBindingResult.hasErrors())
		{
			return "student-form";
		}
		else
		{
			return "student-confirmation";
		}
		
	}

}
