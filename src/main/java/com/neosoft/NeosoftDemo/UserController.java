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

import com.neosoft.NeosoftDemo.entity.ManageProduct;
import com.neosoft.NeosoftDemo.entity.ManageUser;
import com.neosoft.NeosoftDemo.repo.UserRepo;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("add")
	public ResponseEntity<ManageUser> register(@RequestBody @Valid ManageUser user){
		userRepo.save(user);
		
		return new  ResponseEntity<ManageUser>(user, HttpStatus.CREATED);		
	}	
	
	@PutMapping("update")
	public ResponseEntity<ManageUser> update(@RequestBody @Valid ManageUser user){
		userRepo.save(user);
		return new ResponseEntity<ManageUser>(user, HttpStatus.CREATED);
	}
	
	@DeleteMapping("remove")
	public ResponseEntity<ManageUser> delete(@RequestParam Integer userid){
		userRepo.deleteById(userid);
		return new ResponseEntity<ManageUser>(HttpStatus.OK);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<ManageUser>> getall() {

		List<ManageUser> mu = userRepo.findAll();
		ResponseEntity<List<ManageUser>> rs = null;
		if (mu != null || mu.isEmpty()) {
			rs = new ResponseEntity<List<ManageUser>>(mu, HttpStatus.OK);
		} else {
			rs=new ResponseEntity<List<ManageUser>>(mu, HttpStatus.NOT_FOUND);
		}

		return rs;

	}
}
