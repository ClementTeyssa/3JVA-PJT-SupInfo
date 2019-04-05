package com.supinfo.suppictures.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.User;

public class JpaUserDao implements UserDao {

	private EntityManagerFactory emf;


    public JpaUserDao(EntityManagerFactory emf){
        this.emf = emf;
    }

    
    public void addUser(User user) {
        EntityManager  em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

	public void removeUser(User user) {
		 EntityManager  em = emf.createEntityManager();
	        em.getTransaction().begin();
	        try {
	            em.remove(em.merge(user));
	            em.getTransaction().commit();
	        } finally {
	            if(em.getTransaction().isActive()){
	                em.getTransaction().rollback();
	            }
	            em.close();
	        }
	}
	
	public void updateUser(User user) {
		EntityManager  em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
	}
	
	public User getUserByUsername(String username) {
		User result = null;

        EntityManager em = emf.createEntityManager();
        try {
        	 Query query = em
                     .createQuery("SELECT u FROM User u WHERE u.username = :username");
             query.setParameter("username", username);
             result = (User) query.getSingleResult();
        } catch (NoResultException e){
            result = null;
        } finally {
            em.close();
        }

        return result;
	}
	
	 public List<User> getAllUsers() {
	        EntityManager em = emf.createEntityManager();
	        List<User> l;
	        try {
	            Query query = em.createQuery("SELECT u FROM User AS u");
	            l = query.getResultList();
	        } finally {
	            em.close();
	        }
	        return l;
	  }
	 
	 public User getUserById(int id) {
			User result = null;

	        EntityManager em = emf.createEntityManager();
	        try {
	        	 Query query = em
	                     .createQuery("SELECT u FROM User u WHERE u.id = :id");
	             query.setParameter("id", id);
	             result = (User) query.getSingleResult();
	        } catch (NoResultException e){
	            result = null;
	        } finally {
	            em.close();
	        }

	        return result;
		}
}
