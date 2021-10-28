package com.neosoft.NeosoftDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.NeosoftDemo.entity.ManageUser;

@Repository
public interface UserRepo extends JpaRepository<ManageUser, Integer>{
	
	

}
