package com.springmvc.blogposts.model;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class AuthorsMapper implements RowMapper<Authors> {

	@Override
	public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authors author = new Authors();
		author.setUsername(rs.getString("username"));
		author.setPassword(rs.getString("password"));
		author.setFullName(rs.getString("fullname"));
		author.setJoinedDate(rs.getDate("joined_date"));
		author.setRoleCode(rs.getInt("role_code"));
		author.setEnabled(rs.getInt("enabled"));
		return author;
	}

}
