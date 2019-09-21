package com.lucida.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucida.example.entity.Card;


public interface CardRepository  extends JpaRepository<Card, Integer>{
	
	

}
