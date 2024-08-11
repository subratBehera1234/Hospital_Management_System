package com.subrat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.subrat.dto.Admin;

@Repository
public class AdminDao {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("subrat");
	
	public void insertAndUpdateAdmin(Admin admin) {
	
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
	}
	
	public Admin fetchAdmin(int id) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		return entityManager.find(Admin.class, id);
	}
	
	public List<Admin> fetchAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT d FROM Admin d");
		List<Admin>admins=query.getResultList();
		
		return admins;
		
	}
	
	public List<Admin> verifyByEmailAndPassword(String email,String passwoprd){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		javax.persistence.Query query=entityManager.createQuery("SELECT d FROM Admin d WHERE d.email=?1 AND d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, passwoprd);
		
		List<Admin> list=query.getResultList();
		
		return list;
	}
	
	public boolean deleteAdminById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Admin admin=entityManager.find(Admin.class,id);
		
		if(admin != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager);
			entityTransaction.commit();
			
			return true;
		}
		
		return false;
	}
}
