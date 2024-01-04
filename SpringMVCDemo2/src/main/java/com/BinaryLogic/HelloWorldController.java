package com.BinaryLogic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-Form";
	}
	@RequestMapping("/helloWorld")
	public String processForm() {
		return "helloWorld";
	}
	@RequestMapping("/processForm2")
	public String processForm(HttpServletRequest request, Model model) {
		String message = "you have chosen to poop "+request.getParameter("pooper").toLowerCase();
		model.addAttribute("message", message);
		return "helloWorld";
	}
	@RequestMapping("/nuStu")
	public String showStudentForm(Model m) {
		m.addAttribute("student", new Student());
		return "stuForm";
	}
	@RequestMapping("/processStuForm")
	public String processStudentForm(@ModelAttribute("student") Student theStudent) {
		return "stu-confirmation";
	}
}
