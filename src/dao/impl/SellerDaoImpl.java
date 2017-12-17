package dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.SellerDao;
import dao.exception.DaoException;
import domain.Seller;
import domain.User;

public class SellerDaoImpl implements SellerDao{
	
	private DataSource dataSource;

    public SellerDaoImpl(DataSource dataSource)
    {
        super();
        this.dataSource = dataSource;
    }
	
	public Seller find(String name,String password) {
		try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from seller where name=? and password=?";
            Object params[] = {name, password};
            return (Seller) runner.query(sql, params, new BeanHandler(Seller.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
	}

	@Override
	public void add(Seller seller) {
		try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "insert into seller(name,password) values(?,?)";
            Object params[] = {seller.getName(), seller.getPassword()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
		
	}
}
