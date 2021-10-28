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
import com.neosoft.NeosoftDemo.entity.ManageProduct;
import com.neosoft.NeosoftDemo.entity.ManageUser;
import com.neosoft.NeosoftDemo.repo.ProductRepo;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("add")
	public ResponseEntity<ManageProduct> register(@RequestBody @Valid ManageProduct product){
		productRepo.save(product);
		
		return new  ResponseEntity<ManageProduct>(product, HttpStatus.CREATED);		
	}	
	
	@PutMapping("update")
	public ResponseEntity<ManageProduct> update(@RequestBody @Valid ManageProduct product){
		productRepo.save(product);
		return new ResponseEntity<ManageProduct>(product, HttpStatus.CREATED);
	}
	
	@DeleteMapping("remove")
	public ResponseEntity<ManageProduct> delete(@RequestParam Integer productId){
		productRepo.deleteById(productId);
		return new ResponseEntity<ManageProduct>(HttpStatus.OK);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<ManageProduct>> getall() {

		List<ManageProduct> mp = productRepo.findAll();
		ResponseEntity<List<ManageProduct>> rs = null;
		if (mp != null || mp.isEmpty()) {
			rs = new ResponseEntity<List<ManageProduct>>(mp, HttpStatus.OK);
		} else {
			rs=new ResponseEntity<List<ManageProduct>>(mp, HttpStatus.NOT_FOUND);
		}

		return rs;

	}
	
	

}
