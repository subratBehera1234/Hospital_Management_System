package com.subrat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.subrat.dto.Doctor;

import net.bytebuddy.matcher.ElementMatcher;

@Repository
public class DoctorDao {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("subrat");
	
	public void insertAndUpdateDoctor(Doctor doctor) {
	
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(doctor);
		entityTransaction.commit();
	}
	
	public Doctor fetchDoctor(int id) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		return entityManager.find(Doctor.class, id);
	}
	
	public List<Doctor> fetchAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT d FROM Doctor d");
		List<Doctor>doctors=query.getResultList();
		
		return doctors;
		
	}
	
	public List<Doctor> verifyByEmailAndPassword(String email,String passwoprd){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		javax.persistence.Query query=entityManager.createQuery("SELECT d FROM Doctor d WHERE d.email=?1 AND d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, passwoprd);
		
		List<Doctor> list=query.getResultList();
		
		return list;
	}
	
	public boolean deleteDoctorById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Doctor doctor=entityManager.find(Doctor.class,id);
		
		if(doctor != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager);
			entityTransaction.commit();
			
			return true;
		}
		
		return false;
	}
}
