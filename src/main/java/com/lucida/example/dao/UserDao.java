package com.lucida.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucida.example.entity.User1;

@Repository

public interface UserDao extends CrudRepository<User1, Long> {

	//List<User> findByEmailid(String emailId);

	User1 findByEmail(String email);

	User1 findByUsername(String username);
}
