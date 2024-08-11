package com.subrat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.subrat.dao.AdminDao;
import com.subrat.dao.AppointmentDao;
import com.subrat.dao.DoctorDao;
import com.subrat.dao.UserDao;
import com.subrat.dto.Appointment;
import com.subrat.dto.Doctor;
import com.subrat.dto.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	AppointmentDao appointmentDao;
	
	@PostMapping("/user_register")
	public ModelAndView userRegister(@ModelAttribute User user) {
		
		ModelAndView mav =new ModelAndView("user_register.jsp");
		userDao.insertAndUpdateUser(user);
		mav.addObject("success","User Registered Successfully");
		return mav;
	}
	
	@PostMapping("/user_login")
	public ModelAndView userLogin(HttpSession session,@RequestParam("email") String email,@RequestParam("password") String password) {
		
	
		List<User> list=userDao.verifyByEmailAndPassword(email, password);
		if(list.isEmpty()) {
			ModelAndView mav=new ModelAndView("user_login.jsp");
			mav.addObject("failed","Invalid Email or Password");
			return mav;
		}
		
		session.setAttribute("userId", list.get(0).getId());
		ModelAndView mav=new ModelAndView("user/user_home.jsp");
		return mav;
	}
	
	@PostMapping("/add_appointment")
	public ModelAndView addAppointment(@ModelAttribute Appointment appointment, @RequestParam int doctorId,@RequestParam int userId) {
		
		ModelAndView mav = new ModelAndView();
		
		Doctor doctor=doctorDao.fetchDoctor(doctorId);
		
		appointment.setDoctor(doctor);
		doctor.setAppointment(appointment);
		
		User user=userDao.fetchUser(userId);
		List<Appointment> list= new ArrayList<>();
		list.add(appointment);
		
		user.setAppointment(list);
		appointment.setUser(user);
		
		appointmentDao.insertAndUpdateAppointment(appointment);
		return mav;
	}
	
	@GetMapping("/temp_add_appointment")
	public ModelAndView temp_add_appointment() {
		ModelAndView mav =new ModelAndView("user/add_appointment");
		return mav;
	}
	
	@GetMapping("/view_appointment")
	public ModelAndView view_appointment() {
		ModelAndView mav =new ModelAndView("user/view_appointment");
		return mav;
	}

}
