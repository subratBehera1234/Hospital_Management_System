package com.subrat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.subrat.dto.Appointment;

@Repository
public class AppointmentDao {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("subrat");
	
	public void insertAndUpdateAppointment(Appointment appointment) {
	
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(appointment);
		entityTransaction.commit();
	}
	
	public Appointment fetchAppointment(int id) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		return entityManager.find(Appointment.class, id);
	}
	
	public List<Appointment> fetchAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT d FROM Appointment d");
		List<Appointment>appointments=query.getResultList();
		
		return appointments;
		
	}
	
	public List<Appointment> verifyByEmailAndPassword(String email,String passwoprd){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		javax.persistence.Query query=entityManager.createQuery("SELECT d FROM Appointment d WHERE d.email=?1 AND d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, passwoprd);
		
		List<Appointment> list=query.getResultList();
		
		return list;
	}
	
	public boolean deleteAppointmentById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Appointment appointment=entityManager.find(Appointment.class,id);
		
		if(appointment != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager);
			entityTransaction.commit();
			
			return true;
		}
		
		return false;
	}

}
