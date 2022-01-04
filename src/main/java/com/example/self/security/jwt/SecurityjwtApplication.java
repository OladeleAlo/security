package com.example.self.security.jwt;

import com.example.self.security.jwt.entity.Role;
import com.example.self.security.jwt.entity.User;
import com.example.self.security.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityjwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"USER"));
			userService.saveRole(new Role(null,"MANAGER"));
			userService.saveRole(new Role(null,"ADMIN"));
			userService.saveRole(new Role(null,"SUPER_ADMIN"));

			userService.saveUser(new User(null,"CRONALDO","CR7","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"BRUNO FERNENDEZ","PEN","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"RAGNAR","VI","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"DEGE","DAVIDO","12345",new ArrayList<>()));

			userService.addRoleToUser("CR7","SUPER_ADMIN");
			userService.addRoleToUser("PEN","ADMIN");
			userService.addRoleToUser("CR7","MANAGER");
			userService.addRoleToUser("CR7","USER");
			userService.addRoleToUser("VI","USER");
			userService.addRoleToUser("DAVIDO","MANAGER");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
