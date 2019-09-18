package com.lucida.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lucida.example.dtos.Response;
import com.lucida.example.entity.Menu;

import com.lucida.example.service.MenuService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MenuController {

	
	@Autowired
	private MenuService menuService ;
	
	
	@RequestMapping("/addmenu")
	public ResponseEntity<Response> SaveRestaurants(@RequestBody Menu menu) {
		menuService .addMenu(menu);
		return getResponse(200, "SUCCESS", "");
	}


	private ResponseEntity<Response> getResponse(int statusCode, String errorDescription, String successDescription) {
		Response response = new Response(statusCode, successDescription, successDescription);
		response.setStatusCode(statusCode);
		response.setDescription(errorDescription);
		response.setStatus(successDescription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
