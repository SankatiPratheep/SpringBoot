package com.neosoft.NeosoftDemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.NeosoftDemo.entity.ManageAddress;
import com.neosoft.NeosoftDemo.repo.AddressRepo;

@RestController
@RequestMapping("Address")
public class AddressController {
	
	@Autowired
	private AddressRepo addressRepo;
	
	@PostMapping("add")
	public ResponseEntity<ManageAddress> register(@RequestBody @Valid ManageAddress address){
		
		
		if(address.getAddress1()==null) {
			
			throw new AppValidation("Customized Exception");
			
		}else {
		
		ManageAddress save = addressRepo.save(address);
		return new  ResponseEntity<ManageAddress>(address,HttpStatus.CREATED);	
		
		}
		
		
	}	
	
	@PutMapping("update")
	public ResponseEntity<ManageAddress> update(@RequestBody @Valid ManageAddress address){
		addressRepo.save(address);
		return new ResponseEntity<ManageAddress>(address,HttpStatus.CREATED);
	}
	
	@DeleteMapping("remove")
	public ResponseEntity<ManageAddress> delete(@RequestParam Integer addressid){
		addressRepo.deleteById(addressid);
		return new ResponseEntity<ManageAddress>(HttpStatus.OK);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<ManageAddress>> getall() {

		List<ManageAddress> ma = addressRepo.findAll();
		ResponseEntity<List<ManageAddress>> rs = null;
		if (ma != null || ma.isEmpty()) {
			rs = new ResponseEntity<List<ManageAddress>>(ma, HttpStatus.OK);
		} else {
			rs=new ResponseEntity<List<ManageAddress>>(ma, HttpStatus.NOT_FOUND);
		}

		return rs;

	}

}
