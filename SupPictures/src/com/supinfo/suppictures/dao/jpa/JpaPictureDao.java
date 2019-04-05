package com.supinfo.suppictures.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;

public class JpaPictureDao implements PictureDao {

	private EntityManagerFactory emf;


    public JpaPictureDao(EntityManagerFactory emf){
        this.emf = emf;
    }
	
	public void addPicture(Picture picture) {
		 EntityManager  em = emf.createEntityManager();
	        em.getTransaction().begin();
	        try {
	            em.persist(picture);
	            em.getTransaction().commit();
	        } finally {
	            if(em.getTransaction().isActive()){
	                em.getTransaction().rollback();
	            }
	            em.close();
	        }
	}
	
	public void removePicture(Picture picture) {
		// TODO Auto-generated method stub
		EntityManager  em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(picture));
            em.getTransaction().commit();
        } finally {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
	}
	
	 public List<Picture> getAllPictures() {
	        EntityManager em = emf.createEntityManager();
	        List<Picture> l;
	        try {
	            Query query = em.createQuery("SELECT p FROM Picture AS p");
	            l = query.getResultList();
	        } finally {
	            em.close();
	        }
	        return l;
	  }
	 
	  public Picture getPictureById(Long id) {
	        EntityManager em = emf.createEntityManager();
	        try {
	            Query query = em
	                    .createQuery("SELECT p FROM Picture p WHERE p.id = :id");
	            query.setParameter("id", id);
	            return (Picture) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        } finally {
	            em.close();
	        }
	    }

	@Override
	public void updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		EntityManager  em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(picture);
            em.getTransaction().commit();
        } finally {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
	}
	
	public Category getCategoryByIdWithPicture(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT c FROM Category c LEFT JOIN FETCH c.pictures WHERE c.id = :id");
            query.setParameter("id", id);
            return (Category) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
	
	public User getUserByIdWithPicture(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT u FROM User u LEFT JOIN FETCH u.users WHERE u.id = :id");
            query.setParameter("id", id);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
