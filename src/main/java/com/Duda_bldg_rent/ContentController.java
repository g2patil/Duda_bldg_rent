package com.Duda_bldg_rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import model.MyUser;
import model.MyUserRepository;


@Controller
@RestController
@RequestMapping("/adnya")
public class ContentController {

	@GetMapping("/home")
	public String handerWelcome() {
		return "Home";
	}
	
	@GetMapping("/admin/home")
	public String handeradminWelcome() {
		return "Admin Home";
	}
	
	@GetMapping("/user/home")
	public String handeruserWelcome() {
		return "User Home";
	}
	@Autowired
	private MyUserRepository myUserRepository;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return myUserRepository.save(user);
	
}
	@Autowired
    private AuthenticationManager authenticationManager;
	
	 @PostMapping("/login")
	    public boolean login(@RequestBody AuthRequest authRequest) {
	        try {
	            Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            authRequest.getUsername(),
	                            authRequest.getPassword()
	                    )
	            );
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            return true;
	        } catch (AuthenticationException e) {
	            return false;
	        }
	    }
	
	
	
}
