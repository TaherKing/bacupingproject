package com.springbootloginandlogout1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootloginandlogout1.dto.Login;
import com.springbootloginandlogout1.repository.LoginRepository;


@Service
public class LoginService 
{
	@Autowired
	private LoginRepository repo;
	  
	 

	



	public Login Login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		   return user;
	}
}