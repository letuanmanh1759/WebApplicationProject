package com.springmvc.blogposts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.blogposts.dao.AuthorsDao;
import com.springmvc.blogposts.model.Authors;

@Service
public class AuthorsService {

	@Autowired
	AuthorsDao authorsDao;

	public void insertAuthor(Authors author) {
		authorsDao.insertAuthor(author);
	}

	public Authors findByUsername(String username) {

		return authorsDao.findByUsername(username);
	}

	public List<Authors> findAll() {
		
		return authorsDao.findAll();
	}
}
