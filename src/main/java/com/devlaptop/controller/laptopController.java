package com.devlaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devlaptop.model.laptop;
import com.devlaptop.service.laptopService;

@RestController
public class laptopController {

	//dependency injection for service
	@Autowired
	private laptopService service;
	
	//handling request
	@RequestMapping(method=RequestMethod.POST ,value="/laptop")
	public ResponseEntity<String> addLaptop(@RequestBody laptop l1) {
		String status=service.addLaptop(l1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//sending list of laptops
	@RequestMapping(method=RequestMethod.GET ,value="/laptop")
	public ResponseEntity<List<laptop>> getLaptop() {
		return new ResponseEntity<>(service.getLaptop(),HttpStatus.OK);
	}
	
	
	
	
	

}
