package com.AadharCardDetails.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AadharCardDetails.User.bean.User;
import com.AadharCardDetails.User.repo.Userrepository;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class userController {

	
	@Autowired
	public Userrepository userrepo;



	
// It i used to get all the Users that are present in the DataBase
	@GetMapping(path="/Users")
	public List<User> getAllTodos(){
		return userrepo.findAll(); 
	}
	
// It is used to get a particular user by User ID 
	@GetMapping(path="/User/{id}")
	public User getuserbyID(@PathVariable int id ){
		return userrepo.findById(id).get();
	}
	
	
 // API to add User's Aadhar Details in  the User Table  
	@PostMapping(path="/User/Detail")
	public ResponseEntity<User> Adduser(@RequestParam("name") String name ,@RequestParam("address") String address,@RequestParam("aadharNumber") Long aadharNumber ,@RequestParam("date") String date , @RequestParam("frontImage") MultipartFile frontImage , @RequestParam("backImage") MultipartFile backImage   ) throws IOException, ParseException
	{
		
	User user = new User();
	user.setName(name);
	user.setAddress(address);
	user.setAahdarNumber(aadharNumber);
	user.setBackImage(backImage.getBytes());
	user.setFrontImage(frontImage.getBytes());               
    Date date1=new SimpleDateFormat("YYYY-MM-DD").parse(date);  
	user.setDate(date1);

	User u = userrepo.save(user);

	if(u.getId()>0)
	{
return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	else 
		return new ResponseEntity<User>(u, HttpStatus.BAD_REQUEST);	
	}

	
}
