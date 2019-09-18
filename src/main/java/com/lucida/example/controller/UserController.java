package com.lucida.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucida.example.dao.EmailRepository;
import com.lucida.example.dtos.Response;
import com.lucida.example.entity.User1;
import com.lucida.example.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userDetailsService;

	@RequestMapping("/adduser")
	public ResponseEntity<Response> SaveUser(@RequestBody User1 user) {
		userDetailsService.save(user);
		return getResponse(200, "SUCCESS", "");

	}
//	@RequestMapping(path = "/adduser", consumes = "application/json")
//	public ResponseEntity<Response> SaveUser(@RequestBody UserDetails user){
//		userDetailsService.addUser(user);
//		return getResponse(200, "SUCCESS", "");
	// public String test(@RequestBody User user) {
	// return userDetailsService.toString();
	// }

//	@RequestMapping(path = "/adduser", consumes = "application/x-www-form-urlencoded")
//	public ResponseEntity<Response> SaveUser1(@RequestBody UserDetails user){
//		userDetailsService.addUser(user);
//		return getResponse(200, "SUCCESS", "");
//	}
//	
	@RequestMapping("/getuser")
	public List<User1> getUser() {
		return userDetailsService.findAll();

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
