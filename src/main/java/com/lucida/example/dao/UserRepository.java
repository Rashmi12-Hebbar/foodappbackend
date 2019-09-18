package com.lucida.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucida.example.entity.User1;

@Repository
public interface UserRepository extends JpaRepository<User1, Integer>{

	
	

}
