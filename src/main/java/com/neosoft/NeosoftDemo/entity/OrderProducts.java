package com.neosoft.NeosoftDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderProducts {
	
	@Id
	@GeneratedValue
	private Integer orderItem;
	@OneToOne
	private Order order;
	private Double productPrice;
	private Integer productQuantity;
	
	public Integer getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Integer orderItem) {
		this.orderItem = orderItem;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
