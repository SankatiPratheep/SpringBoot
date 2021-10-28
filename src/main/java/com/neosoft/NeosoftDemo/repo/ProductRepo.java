package com.neosoft.NeosoftDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.NeosoftDemo.entity.ManageProduct;

@Repository
public interface ProductRepo extends JpaRepository<ManageProduct, Integer>{
	

}
