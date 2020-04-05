package com.svlada.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.svlada.entity.User;

/**
 * UserRepository
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public interface UserRepository {
	
	public Optional<User> findByUsername(String username);
	public <S extends User> S save(S user);
	public List<String> getAllUsersNames();
}
