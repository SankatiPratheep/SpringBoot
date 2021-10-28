package com.neosoft.NeosoftDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.NeosoftDemo.entity.ManageAddress;

@Repository
public interface AddressRepo extends JpaRepository<ManageAddress, Integer>{

}
