package com.subrat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.subrat.dao.AdminDao;
import com.subrat.dto.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;

	@PostMapping("/admin_register")
	public ModelAndView adminRegister(@ModelAttribute Admin admin) {
		
		ModelAndView mav=new ModelAndView("admin_register.jsp");
		adminDao.insertAndUpdateAdmin(admin);
		mav.addObject("success","Registered Succefully");
		return mav;
		
	}
	
	@PostMapping("/admin_login")
	public ModelAndView adminLogin(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		List<Admin>admin=adminDao.verifyByEmailAndPassword(email, password);
		if(admin.isEmpty()) {
			
			ModelAndView mav= new ModelAndView("admin_login.jsp");
			mav.addObject("failed","Invalid Email or Password");
			return mav;
		}
		
			ModelAndView mav=new ModelAndView("admin/admin_home.jsp");
		
		return mav;
		
	}
	
	@GetMapping("/temp_admin_home")
	public ModelAndView tempHome() {
		ModelAndView mav=new ModelAndView("admin/admin_home.jsp");
		return mav;
	}
	
}
