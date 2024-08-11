package com.subrat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.subrat.dto.User;

@Repository
public class UserDao {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("subrat");
	
	public void insertAndUpdateUser(User user) {
	
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	public User fetchUser(int id) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		return entityManager.find(User.class, id);
	}
	
	public List<User> fetchAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT d FROM User d");
		List<User>users=query.getResultList();
		
		return users;
		
	}
	
	public List<User> verifyByEmailAndPassword(String email,String passwoprd){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		javax.persistence.Query query=entityManager.createQuery("SELECT d FROM User d WHERE d.email=?1 AND d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, passwoprd);
		
		List<User> list=query.getResultList();
		
		return list;
	}
	
	public boolean deleteUserById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user=entityManager.find(User.class,id);
		
		if(user != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager);
			entityTransaction.commit();
			
			return true;
		}
		
		return false;
	}
}
