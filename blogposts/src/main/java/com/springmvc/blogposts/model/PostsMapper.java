package com.springmvc.blogposts.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PostsMapper implements RowMapper<Posts> {
	public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
		Posts post = new Posts();
		post.setId(rs.getInt("id"));
		post.setAuthor(rs.getString("author"));
		post.setTitle(rs.getString("title"));
		post.setDescription(rs.getString("description"));
		post.setContent(rs.getString("content"));
		post.setCreatedDate(rs.getDate("created_date"));
		return post;
	}
}