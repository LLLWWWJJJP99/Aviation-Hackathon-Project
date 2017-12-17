package dao;

import domain.Seller;;

public interface SellerDao {
	public Seller find(String name,String password);
	
	public void add(Seller seller);
}
