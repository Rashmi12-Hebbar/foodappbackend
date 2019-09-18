package com.lucida.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucida.example.dao.MenuRepository;
import com.lucida.example.dao.UserRepository;
import com.lucida.example.entity.Menu;

@Service
public class MenuService {
	
	
	@Autowired
	private MenuRepository menuRepository;
	
	public void addMenu(Menu menu) {
		menuRepository.save(menu);
		// TODO Auto-generated method stub
		
	}
	

}
