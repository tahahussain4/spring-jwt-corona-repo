package com.svlada;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.svlada.user.repository.InMemoryUserRepository;
import com.svlada.user.repository.UserRepository;

@Configuration
public class AppConfig {
	@Bean
	public UserRepository getUserRepo(){
		return new InMemoryUserRepository();
	}
}
