package com.springmvc.blogposts;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/blogposts");
		dataSource.setUsername("root");
		dataSource.setPassword("toor");
		return dataSource;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource())
				.usersByUsernameQuery("SELECT username, password, enabled FROM authors WHERE username = ?")
				.authoritiesByUsernameQuery(
						"SELECT authors.username, roles.role_name FROM authors, roles WHERE username = ? AND authors.role_code = roles.id ");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").and()
				.authorizeRequests().antMatchers("/user/**").hasRole("USER").anyRequest().permitAll().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/home").failureUrl("/login?error=failed").and()
				.exceptionHandling().accessDeniedPage("/login?error=deny");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");

	}

}
