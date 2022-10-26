package com.devlaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devlaptop.model.developer;
import com.devlaptop.service.developerService;

@RestController
public class developerController {
	
	//injecting service
	@Autowired
	private developerService service;
	
	//adding developers
	@PostMapping("/developer")
	public ResponseEntity<String> addDeveloper(@RequestBody developer d1){
		String status=service.addDeveloper(d1);
		
		if(status!=null) {
			//sending response entity along with status
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@RequestMapping(method=RequestMethod.GET, value="/developer")
	
	//retriving developers
	@GetMapping("/developer")
	public ResponseEntity<List<developer>> getAllDevs(){
		 return new ResponseEntity<>(service.getAllDevs(),HttpStatus.OK);
	}
	
	
	
	
	
}
