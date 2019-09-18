package com.lucida.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "restaurants")
public class restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	@Column(name="restaurants_name")
	private String restaurants_name;
	
	@Column(name="restid")
	private int restid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRestaurants_name() {
		return restaurants_name;
	}

	public void setRestaurants_name(String restaurants_name) {
		this.restaurants_name = restaurants_name;
	}

	public int getRestid() {
		return restid;
	}

	public void setRestid(int restid) {
		this.restid = restid;
	}

	public restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public restaurants(int id, String restaurants_name, int restid) {
		super();
		this.id = id;
		this.restaurants_name = restaurants_name;
		this.restid = restid;
	}

	

	
	
	
}
