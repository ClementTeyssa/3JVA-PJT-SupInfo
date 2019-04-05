package com.supinfo.suppictures.dao;

import java.util.List;

import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;

public interface PictureDao {
	void addPicture(Picture picture);
	void removePicture(Picture picture);
	void updatePicture(Picture picture);
	List<Picture> getAllPictures();
	Picture getPictureById(Long id);
	Category getCategoryByIdWithPicture(Long id);
	User getUserByIdWithPicture(Long id);
}
