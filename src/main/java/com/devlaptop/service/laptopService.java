package com.devlaptop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		return laprepo.findAll();
	}
		
	//updating the existing laptop in db
	public String updateLaptop(laptop l1)
	{
		laptop _l2=laprepo.save(l1);
		if(_l2!=null) {
			return "laptop updated "+new Date();
		}
		else {
			return null;
		}
	}
	
	//deleting laptop based on lapid if it is existed in db
	public String deleteLaptop(int lapid) {
		
		Optional<laptop> _l1=laprepo.findById(lapid);
		if(_l1!=null) {
			laprepo.deleteById(lapid);
			return "laptop deleted";
		}
		else {
			return null;
		}
	}
	
	//retriving list of laptops in sorted
	public List<laptop> getLaptops(String field){
		
		return laprepo.findAll(Sort.by(Direction.DESC,field));
		
	}
	
	//retriving different page of laptops based on offset and pagesize
	public Page<laptop> getProductwithPagination(int offset,int pagesize){
		
		return laprepo.findAll(PageRequest.of(offset, pagesize));
		
	//100 rows in a table
		//10 rows per page-offset
		//10 pages-pagesize
	}
	
	
	
	
	
	
	
	
	
}



