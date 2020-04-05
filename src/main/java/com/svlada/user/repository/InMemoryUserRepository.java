package com.svlada.user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.svlada.entity.User;

public class InMemoryUserRepository implements UserRepository  {
	BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
	ArrayList<User> users = new ArrayList<User>();
	public <S extends User> S save(S user) {
		System.out.println("saving user IN MEMORY ================================");
		System.out.println("saving user");
		users.add(user);
		return user;
	}

	public Optional<User> findByUsername(String username) {
		System.out.println("using in memeory configuration");
		User user = null;
		for(User user2 : users){
			if(user2.getUsername().equals(username)){
				user = user2;
				return Optional.of(user);
			}
		}
		return Optional.ofNullable(null);
	}

	@Override
	public List<String> getAllUsersNames() {
		ArrayList<String> usernames = new ArrayList<String>();
		for(User user : users){
			usernames.add(user.getUsername());
		}
		return usernames;
	}

}
