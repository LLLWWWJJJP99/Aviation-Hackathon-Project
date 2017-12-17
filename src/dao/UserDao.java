package dao;

import domain.Seller;
import domain.User;

public interface UserDao {
	public void add(User user);
	
	public User find(String name,String password);

}
