package com.lucida.example.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class User1 {

    public User1(int id, String email, String password, String confirmpassword, String username) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.username = username;
	}

	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String confirmpassword;
    
    @Column
    private String username;
    
    
    
}
