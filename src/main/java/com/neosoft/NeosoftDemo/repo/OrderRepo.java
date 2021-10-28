package com.neosoft.NeosoftDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.NeosoftDemo.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
