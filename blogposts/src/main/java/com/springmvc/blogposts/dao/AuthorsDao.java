package com.springmvc.blogposts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.blogposts.model.Authors;
import com.springmvc.blogposts.model.AuthorsMapper;


@Repository
public class AuthorsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertAuthor(Authors author) {
		String sql = "INSERT INTO authors (username, password, fullname, joined_date, role_code, enabled) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, author.getUsername(), author.getPassword(), author.getFullName(),
				author.getJoinedDate(), author.getRoleCode(), author.getEnabled());
	}

	public Authors findByUsername(String username) {
		String sql = "SELECT * FROM authors WHERE username = ?";
		return jdbcTemplate.queryForObject(sql, new AuthorsMapper(), username);
	}

	public List<Authors> findAll() {
		String sql = "SELECT * FROM authors";
		return jdbcTemplate.query(sql, new AuthorsMapper());
	}

}
