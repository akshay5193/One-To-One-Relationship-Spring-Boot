package com.akshay.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.relationships.models.License;
import com.akshay.relationships.services.LicenseService;
import com.akshay.relationships.services.PersonService;

@Controller
public class LicensesController {

	@Autowired
	private LicenseService licenseService;
	
	@Autowired
	private PersonService personService;
	
	 static Integer count = 0;
	
	@GetMapping("/licenses/new")
	public String addNewLicensePage(@ModelAttribute ("license") License license, Model model) {
		model.addAttribute("persons", personService.getAllPeople());
		return "/licenses/newLicense.jsp";
	}
	
	@PostMapping ("/licenses")
	public String addNewLicense(@Valid @ModelAttribute ("license") License license, BindingResult result) {
		System.out.println("***************INSIDE FUCTION********************");
		if (result.hasErrors()) {
			System.out.println("*************** IF IS WORKING  ********************");
			return "/licenses/newLicense.jsp";
		}
		else {
			System.out.println("***************INSIDE ElSE********************");
			count++;
			System.out.println("Counter Value: " + count);
			StringBuilder licenseNumber = new StringBuilder();
			licenseNumber.append(count);
			while(licenseNumber.length()!=6) {
				licenseNumber.insert(0, "0");
			}
			licenseService.createLicense(licenseNumber.toString(), license);
			return "redirect:/persons";
		}
	}
}
