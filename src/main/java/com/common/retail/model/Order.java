package com.common.retail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order")
public class Order {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ordername;
	private int ordernumber;
	private String ordertype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", ordername=" + ordername + ", ordernumber=" + ordernumber + ", ordertype="
				+ ordertype + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
