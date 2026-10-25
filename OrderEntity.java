package com.jsp.ai.Entity;

import java.math.BigInteger;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_master")
public class OrderEntity {

	@jakarta.persistence.Id
	@Column(name = "order_id")
	private BigInteger orderid;

	@Column(name = "product_name")
	private String productname;

	@Column(name = "order_status")
	private String orderstatus;

	@Column(name = "price")
	private long price;

	public BigInteger getOrderid() {
		return orderid;
	}

	public void setOrderid(BigInteger orderid) {
		this.orderid = orderid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
