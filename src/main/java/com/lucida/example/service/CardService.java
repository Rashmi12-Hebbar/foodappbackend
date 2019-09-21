package com.lucida.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucida.example.dao.CardRepository;
import com.lucida.example.dao.EmailRepository;
import com.lucida.example.entity.Card;


@Service
public class CardService {
	
	
	
	@Autowired
    private CardRepository cardRepository ;
	@Autowired
	private EmailRepository  emailRepository ;
	
	
	public void addCard(Card card) {
		cardRepository.save(card);
		// TODO Auto-generated method stub
		
	}
	public boolean validateCard(Card cardname) {
		return emailRepository.validateCard(cardname);
		}
}
