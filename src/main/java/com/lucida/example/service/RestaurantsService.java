package com.lucida.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucida.example.dao.EmailRepository;
import com.lucida.example.dao.MenuRepository;
import com.lucida.example.dao.RestaurantsRepository;

import com.lucida.example.dao.UserRepository;
import com.lucida.example.entity.restaurants;
import com.lucida.example.entity.Menu;
import com.lucida.example.entity.User1;

@Service
public class RestaurantsService {

	@Autowired
	private RestaurantsRepository restaurantsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private EmailRepository emailRepository;
	
	public void addRestaurants(restaurants restaurants) {
		restaurantsRepository.save(restaurants);
	}
	
	
	// getting all id's
	public List<restaurants> getRestaurants() {
		return restaurantsRepository.findAll();
	}


	public void updateRestaurants(restaurants restaurants) {
		restaurantsRepository.save(restaurants);

	}
	
	
	public boolean validateemail(User1 email) {
	return emailRepository.validateEmail(email);
	}


	public void deleteUser(int id) {
		userRepository.deleteById(id);

		}
	
	public void updateUser(User1 user) {
		userRepository.save(user);

		}


	public void deleteRestaurants(int id) {
		// TODO Auto-generated method stub
		restaurantsRepository.deleteById(id);
	}


//
//	public void updateRestaurants(int id) {
//		restaurantsRepository.findById(id);
//		// TODO Auto-generated method stub
//		
////	}

	
	




//	public void updateRestaurants(int id) {
//		restaurantsRepository.findById(id);// TODO Auto-generated method stub
//		
//	}
}
