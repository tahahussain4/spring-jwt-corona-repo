package com.svlada.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svlada.entity.Role;
import com.svlada.entity.User;
import com.svlada.entity.UserRole;
import com.svlada.user.service.DatabaseUserService;

/**
 * RefreshTokenEndpoint
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
@Component
@RestController
public class UserController {
	
	@Autowired
	DatabaseUserService userRepo;
    
    @RequestMapping(value="/api/register", method=RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody boolean register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	System.out.println("i am in register =================================================");
    	
    	ObjectMapper mapper = new ObjectMapper();
    	RegisterRequest rq = mapper.readValue(request.getReader(), RegisterRequest.class);
    	
    	ArrayList<UserRole> roles  = new ArrayList<UserRole>();
    	roles.add(new UserRole(Role.MEMBER));
    	User user = new User(null,rq.getUsername(),rq.getPassword(),roles);
    	User returnedUser = userRepo.register(user);
    	if(returnedUser != null){
    		return true;
    	} else{
    		return false;
    	}
    	//log him in and send token back	
    }
    
    
    @RequestMapping(value="/api/getAllUsers", method=RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<String> allUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	System.out.println("i am in getAllUsers =================================================");
//    	return new ArrayList<String>();
    	return userRepo.getAllUsers();
    	//log him in and send token back	
    }

    
    
}
