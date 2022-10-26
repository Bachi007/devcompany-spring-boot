package com.devlaptop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devlaptop.model.laptop;
import com.devlaptop.repository.laptopRepository;

@Service
public class laptopService {
	//dependency injection for repository
	@Autowired
	private laptopRepository laprepo;
	//adding laptop to db
	public String addLaptop(laptop l1) {
		String msg=null;
		laptop _l2=laprepo.save(l1);
		if(_l2!=null) {
			msg= "laptop added!... @"+new Date();
		}
		else {
			msg=null;
		}
		return msg;
	}
	//retriving list of laptops
	public List<laptop> getLaptop(){
		
		List<laptop> laptopList=new ArrayList<>();
		laprepo.findAll().forEach(laptopList::add);
		return laptopList;
	}
	
	
	
	
	
}
