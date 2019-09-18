package com.lucida.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucida.example.entity.Menu;
import com.lucida.example.entity.restaurants;

@Repository
public interface RestaurantsRepository extends JpaRepository<restaurants, Integer>{

	void save(Menu menu);

}

