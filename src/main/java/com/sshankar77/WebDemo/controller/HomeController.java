package com.sshankar77.WebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sshankar77.WebDemo.service.CalcService;

@Controller

public class HomeController {

	@Autowired
	CalcService service;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value="/home", method = RequestMethod.POST)
    public String showHomePage(ModelMap model, @RequestParam String num1,  @RequestParam String num2, @RequestParam char operation, @RequestParam String result){
		String errorMessage = "";
		boolean isValidnum1 = service.validatenum(num1);
		boolean isValidnum2 = service.validatenum(num2);
//    	System.out.println("num1="+isValidnum1);
//    	System.out.println("num2="+isValidnum2);
		if (!isValidnum1) {
			errorMessage = "Invalid Number1";
		}
		if (!isValidnum2) {
			errorMessage = "Invalid Number2";
		}
		if (!isValidnum1 && !isValidnum2) {
			errorMessage = "Invalid Number1 & 2";
		}
		model.put("num1",num1);
		model.put("num2",num2);
		model.put("operation",operation);
	    if (isValidnum1 && isValidnum2) {
	    	result = service.calc(num1,num2,operation);
	    }
		model.put("result",result);
		model.put("eMsg",errorMessage);
    	System.out.println("num1="+num1);
    	System.out.println("num2="+num2);
    	System.out.println("result="+result);
    	System.out.println("eMess="+errorMessage);
		return "home";
    }
}
