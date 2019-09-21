package com.lucida.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cardDetail")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	@Column(name="cardname")
	private String cardname;
	
	@Column(name="credit_card_number")
	private int credit_card_number;


	public Card(int id, String cardname, int credit_card_number, int cvv) {
		super();
		this.id = id;
		this.cardname = cardname;
		this.credit_card_number = credit_card_number;
		this.cvv = cvv;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCardname() {
		return cardname;
	}


	public void setCardname(String cardname) {
		this.cardname = cardname;
	}


	public int getCredit_card_number() {
		return credit_card_number;
	}


	public void setCredit_card_number(int credit_card_number) {
		this.credit_card_number = credit_card_number;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	@Column(name="cvv")
	private int cvv;

}
