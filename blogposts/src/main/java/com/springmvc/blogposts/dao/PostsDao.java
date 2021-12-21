package com.springmvc.blogposts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.blogposts.model.Posts;
import com.springmvc.blogposts.model.PostsMapper;

@Repository
public class PostsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Posts> findAll() {
		String sql = "SELECT * FROM posts";
		return jdbcTemplate.query(sql, new PostsMapper());
	}

	public Posts findById(int id) {
		String sql = "SELECT * FROM posts WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new PostsMapper(), id);
	}

	public List<Posts> findByUsername(String username) {
		String sql = "SELECT * FROM posts WHERE author = ?";
		return jdbcTemplate.query(sql, new PostsMapper(), username);

	}

}
