package com.springmvc.blogposts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.blogposts.dao.PostsDao;
import com.springmvc.blogposts.model.Posts;

@Service
public class PostsService {

	@Autowired
	private PostsDao postsDao;

	public List<Posts> findAll() {
		return postsDao.findAll();
	}

	public Posts findById(int id) {
		return postsDao.findById(id);
	}

	public List<Posts> findByUsername(String username) {
		return postsDao.findByUsername(username);
	}
}
