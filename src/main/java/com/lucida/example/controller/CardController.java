package com.lucida.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucida.example.dtos.Response;
import com.lucida.example.entity.Card;
import com.lucida.example.entity.Menu;
import com.lucida.example.service.CardService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CardController {
	
	
	@Autowired
	private CardService cardService;
	
	
	@RequestMapping("/addcard")
	public ResponseEntity<Response> SaveCard(@RequestBody Card card) {
		cardService .addCard(card);
		return getResponse(200, "SUCCESS", "");
	}
	@RequestMapping("/checkcardname")
	public Response validate(@RequestBody Card cardname) {
	if (cardService.validateCard(cardname)) {
	return new Response(200, "valid cardholder", "success");
	} else {
	return new Response(400, "invalid cardholder", "failure");
	}
	}

	private ResponseEntity<Response> getResponse(int statusCode, String errorDescription, String successDescription) {
		Response response = new Response(statusCode, successDescription, successDescription);
		response.setStatusCode(statusCode);
		response.setDescription(errorDescription);
		response.setStatus(successDescription);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
