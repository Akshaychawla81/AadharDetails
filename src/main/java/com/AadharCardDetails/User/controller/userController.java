package com.AadharCardDetails.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AadharCardDetails.User.bean.User;
import com.AadharCardDetails.User.repo.Userrepository;

import java.io.IOException;
import java.util.*;

import java.util.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class userController {

	
	@Autowired
	public Userrepository userrepo;

	@Autowired
	

	@GetMapping(path="/Users")
	public List<User> getAllTodos(){
		return userrepo.findAll(); 
	}
	
	@PostMapping(path="/User/Detail")
	public ResponseEntity<User> Adduser(@RequestBody User user ) throws IOException
	{
	//	{ 	System.out.println(file.getBytes());
//user.setFrontImage(file.getBytes());

	User u = userrepo.save(user);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
		
	}
//	@PutMapping(path="/User/Detail/frontimage/{id}")
//	public ResponseEntity<User> addfrontimage(@PathVariable int id)
//	{ 
//		 User user = userrepo.findById(id).get();
//		 user.setName("Akshay");
//	//	 user.setFrontImage(multipartImage.getBytes());
//		User userupdated = userrepo.saveAndFlush(user);
//		return new ResponseEntity<User>(userupdated, HttpStatus.OK);
//		
//	}
	
}
