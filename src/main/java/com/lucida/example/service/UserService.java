package com.lucida.example.service;

import java.util.List;


import com.lucida.example.entity.User1;

public interface UserService {

    User1 save(User1 user);
    List<User1> findAll();
    void delete(long id);
	User1 findByEmail(String email);
	User1 findOne(String username);
	
}
