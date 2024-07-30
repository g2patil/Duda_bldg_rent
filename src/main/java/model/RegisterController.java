package model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.User;

@RestController
public class RegisterController {
	
	@Autowired
	private MyUserRepository myUserRepository;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return myUserRepository.save(user);
				
		
	}
	
	 
	

}
