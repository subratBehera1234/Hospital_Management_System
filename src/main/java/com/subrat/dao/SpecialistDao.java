package com.subrat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.subrat.dto.Specialist;

@Repository
public class SpecialistDao {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("subrat");
	
	public void insertAndUpdateSpecialist(Specialist specialist) {
	
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(specialist);
		entityTransaction.commit();
	}
	
	public Specialist fetchSpecialist(int id) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		return entityManager.find(Specialist.class, id);
	}
	
	public List<Specialist> fetchAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT d FROM Specialist d");
		List<Specialist>specialists=query.getResultList();
		
		return specialists;
		
	}
	
	public List<Specialist> verifyByEmailAndPassword(String email,String passwoprd){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		javax.persistence.Query query=entityManager.createQuery("SELECT d FROM Specialist d WHERE d.email=?1 AND d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, passwoprd);
		
		List<Specialist> list=query.getResultList();
		
		return list;
	}
	
	public boolean deleteSpecialistById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Specialist specialist=entityManager.find(Specialist.class,id);
		
		if(specialist != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager);
			entityTransaction.commit();
			
			return true;
		}
		
		return false;
	}
}
