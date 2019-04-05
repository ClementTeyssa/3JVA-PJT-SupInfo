package com.supinfo.suppictures.dao;

import java.util.List;

import com.supinfo.suppictures.entity.User;

public interface UserDao {
	void addUser(User user);
	void removeUser(User user);
	void updateUser(User user);
	User getUserByUsername(String username);
	List<User> getAllUsers();
	User getUserById(int id);
}
