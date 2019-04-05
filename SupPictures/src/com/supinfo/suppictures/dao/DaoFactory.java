package com.supinfo.suppictures.dao;

import com.supinfo.suppictures.dao.CategoryDao;
import com.supinfo.suppictures.dao.jpa.JpaCategoryDao;
import com.supinfo.suppictures.dao.jpa.JpaPictureDao;
import com.supinfo.suppictures.dao.jpa.JpaUserDao;
import com.supinfo.suppictures.util.PersistenceManager;

public class DaoFactory {
	private static JpaCategoryDao categoryService;
	private static JpaUserDao userService;
	private static JpaPictureDao pictureDao;

	public static CategoryDao getCategoryDao() {
		if (categoryService == null) {
			categoryService = new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
		}
		return categoryService;
	}
	
	public static PictureDao getPictureDao() {
		if (pictureDao == null) {
			pictureDao = new JpaPictureDao(PersistenceManager.getEntityManagerFactory());
		}
		return pictureDao;
	}
	
	public static UserDao getUserDao() {
		if (userService == null) {
			userService = new JpaUserDao(PersistenceManager.getEntityManagerFactory());
		}
		return userService;
	}
}
