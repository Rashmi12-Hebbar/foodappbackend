package com.lucida.example.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucida.example.dao.UserDao;
import com.lucida.example.entity.User1;
import com.lucida.example.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User1> findAll() {
		List<User1> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User1 save(User1 user) {

		User1 newUser = new User1();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
	newUser.setConfirmpassword(user.getConfirmpassword());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

		return userDao.save(newUser);
	}

	@Override
	public User1 findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User1 findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
