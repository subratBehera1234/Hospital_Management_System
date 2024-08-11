package com.subrat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.subrat.dao.SpecialistDao;
import com.subrat.dto.Specialist;

@Controller
public class SpecialistController {
	
	@Autowired
	private SpecialistDao specialistDao;

	@PostMapping("/add_specialist")
	public ModelAndView addSpecialist(@ModelAttribute Specialist specialist) {
		
		ModelAndView mav= new ModelAndView("doctor/add_specialist.jsp");
		specialistDao.insertAndUpdateSpecialist(specialist);
		mav.addObject("success","Added Successfully");
		return mav;
		
	}
	
	@GetMapping("/temp_specialist")
	public ModelAndView tempSpecialist() {
		
		ModelAndView mav = new ModelAndView("doctor/add_specialist.jsp");
		return mav;
		
	}
}
