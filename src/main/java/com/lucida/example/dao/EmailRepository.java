package com.lucida.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lucida.example.entity.Card;
import com.lucida.example.entity.User1;

@Repository
public class EmailRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean validateEmail(User1 email) {
         
		String sql = "select count(*)>0 from user where email = '" + email.getEmail() + "'AND password = '"
				+ email.getPassword() + "'";
		return this.jdbcTemplate.queryForObject(sql, Boolean.class);

	}
	
	public Boolean validateCard(Card cardname) {
        
		String sql = "select count(*)>0 from card_detail where cardname = '" + cardname.getCardname() + "'AND cvv = '"
				+ cardname.getCvv() + "'";
		return this.jdbcTemplate.queryForObject(sql, Boolean.class);

	}

}