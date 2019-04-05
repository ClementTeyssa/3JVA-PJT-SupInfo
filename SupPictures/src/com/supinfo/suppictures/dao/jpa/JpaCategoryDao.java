package com.supinfo.suppictures.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.supinfo.suppictures.dao.CategoryDao;
import com.supinfo.suppictures.entity.Category;

public class JpaCategoryDao implements CategoryDao {

    private EntityManagerFactory emf;


    public JpaCategoryDao(EntityManagerFactory emf){
        this.emf = emf;
    }

    
    public void addCategory(Category category) {
        EntityManager  em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(category);
            em.getTransaction().commit();
        } finally {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public Category findCategoryById(Long id) {
        Category result;

        EntityManager em = emf.createEntityManager();
        try {
            result = em.find(Category.class, id);
        } catch (NoResultException e){
            result = null;
        } finally {
            em.close();
        }

        return result;
    }


    public List<Category> getAllCategories() {
        EntityManager em = emf.createEntityManager();
        List<Category> l;
        try {
            Query query = em.createQuery("SELECT c FROM Category AS c");
            l = query.getResultList();
        } finally {
            em.close();
        }
        return l;
    }

    public void updateCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(category);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    
    public void removeCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(category));
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    
	public Category getCategoryByIdWithPicture(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em
					.createQuery("SELECT c FROM Category c IN WHERE c.id = :id");
			query.setParameter("id", id);
			return (Category) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
}
