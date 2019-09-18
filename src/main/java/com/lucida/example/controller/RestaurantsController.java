package com.lucida.example.controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lucida.example.dtos.Response;
import com.lucida.example.entity.restaurants;
import com.lucida.example.entity.Menu;
import com.lucida.example.entity.User1;
import com.lucida.example.service.RestaurantsService;
import com.lucida.example.service.UserService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class RestaurantsController {

	@Autowired
	private RestaurantsService  restaurantsService;
	
	
	
	

//	@Autowired
//	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@RequestMapping("/addrestaurants")
	public ResponseEntity<Response> SaveRestaurants(@RequestBody restaurants restaurants) {
		restaurantsService.addRestaurants(restaurants);
		return getResponse(200, "SUCCESS", "");
	}
	
//	@RequestMapping("/addmenu")
//	public ResponseEntity<Response> SaveMenu(@RequestBody Menu menu) {
//		restaurantsService.addMenu(menu);
//		return getResponse(200, "SUCCESS", "");
//	}
	

	@RequestMapping("/getRestaurants")
	public List<restaurants> getRestaurants() {
		return restaurantsService.getRestaurants();
	}

	@RequestMapping("/updateRestaurants")
	public ResponseEntity<Response> SavegetRestaurants(@RequestBody restaurants restaurant) {
		restaurantsService.updateRestaurants(restaurant);
		return getResponse(200, "SUCCESS", "");
	}

	@RequestMapping("/deleteRestaurants")
	public ResponseEntity<Response> SaveEmployee2(@RequestBody restaurants restaurants) {
		restaurantsService.deleteEmployee(restaurants);
		return getResponse(200, "SUCCESS", "");
	}

	
	
	
	
	@RequestMapping("/checkemail")
	public Response validate(@RequestBody User1 email) {
		System.out.println(email);
		if (restaurantsService.validateemail(email)) {
			System.out.println(email);
			return new Response(200, "valid user", "success");
		} else {
			return new Response(400, "invalid user", "failure");
		}	
}
	@PutMapping("/updateuser")
	public ResponseEntity<Response> updateuser(@RequestBody User1 user) {
		restaurantsService.updateUser(user);
	return getResponse(200, "SUCCESS", "");
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Response> Saveuser(@PathVariable int id) {
		restaurantsService.deleteUser(id);
	return getResponse(200, "SUCCESS", "");
	}

	/**
	 * For common Response
	 * 
	 * @param statusCode
	 * @param errorDescription
	 * @param successDescription
	 * @return
	 */
	private ResponseEntity<Response> getResponse(int statusCode, String errorDescription, String successDescription) {
		Response response = new Response(statusCode, successDescription, successDescription);
		response.setStatusCode(statusCode);
		response.setDescription(errorDescription);
		response.setStatus(successDescription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	
}
