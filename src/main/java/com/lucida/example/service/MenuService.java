package com.lucida.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lucida.example.dao.MenuRepository;
import com.lucida.example.dao.UserRepository;
import com.lucida.example.entity.Menu;
import com.lucida.example.entity.restaurants;

@Service
public class MenuService {
	
	
	@Autowired
	private MenuRepository menuRepository;
	
	public void addMenu(Menu menu) {
		menuRepository.save(menu);
		// TODO Auto-generated method stub
	}
	
	public List<Menu> getMenu() {
		return  menuRepository.findAll();
	}

	public void updateMenu(Menu menu) {
		menuRepository.save(menu);

	}
}
