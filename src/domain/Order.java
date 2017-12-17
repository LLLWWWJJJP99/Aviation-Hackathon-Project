package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	
	private String id;
	private User user;
	private Set orderitems = new HashSet();
	private Date ordertime;
	private boolean state;
	private double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
