package com.springbootloginandlogout1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootloginandlogout1.dto.Login;





@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>
{
	Login findByUsernameAndPassword(String username, String password);
}
