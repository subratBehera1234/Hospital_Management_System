package com.subrat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.subrat.dao.DoctorDao;
import com.subrat.dao.SpecialistDao;
import com.subrat.dto.Doctor;
import com.subrat.dto.Specialist;

@Controller
public class DoctorController {

	@Autowired
	SpecialistDao specialistDao;
	
	@Autowired
	DoctorDao doctorDao;
	

	
	@GetMapping("/temp_doctor")
	public ModelAndView tempDoctor() {
		
		ModelAndView mav = new ModelAndView("doctor/addAndUpdateDoctor.jsp");
		Doctor doctor=new Doctor();
		mav.addObject("doctor",doctor);
		
		List<Specialist> list=specialistDao.fetchAll();
		mav.addObject("list",list);
		
		return mav;
		
	}
	
	@PostMapping("/registerAndUpdateDoctor")
	public ModelAndView registerAndUpdateDoctror(@ModelAttribute Doctor doctor) {
		
		doctorDao.insertAndUpdateDoctor(doctor);
		ModelAndView mav = new ModelAndView("admin/admin_home.jsp");
		mav.addObject("success","Updated Successfully");
		return mav;
	}
	
	
}
