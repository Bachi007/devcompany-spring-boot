package com.devlaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//api to update the laptop
	//@PutMapping("/laptop")
	@RequestMapping(method=RequestMethod.PUT, value="/laptop")
	public ResponseEntity<String> updateLaptop(@RequestBody laptop l1){
		
		String status=service.updateLaptop(l1);
		if(status!=null)
		{
		return new ResponseEntity<>(status,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//api to delete the laptop
	@RequestMapping(method=RequestMethod.DELETE,value="/laptop/{lapid}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int lapid){
		
		String status=service.deleteLaptop(lapid);
		if(status!=null)
		{
		return new ResponseEntity<>(status,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//getting list of laptops in sorted order
	@GetMapping("/laptop/{field}")
	public ResponseEntity<List<laptop>> getLaptops(@PathVariable String field){
	
		List<laptop> lapList=service.getLaptops(field);
		return new ResponseEntity<>(lapList,HttpStatus.ACCEPTED);
		
	}
	
	//getting pages based on offset and pagesize
	@GetMapping("/laptop/{offset}/{pagesize}")
	public ResponseEntity<Page<laptop>> getLaptopswithPagination(@PathVariable int offset, @PathVariable int pagesize){
		
		Page<laptop> lapPage=service.getProductwithPagination(offset, pagesize);
		
		return new ResponseEntity<>(lapPage,HttpStatus.OK);
	}
	
	
	
	
}
