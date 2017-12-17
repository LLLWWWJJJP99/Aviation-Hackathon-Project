package dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.UserDao;
import dao.exception.DaoException;
import domain.User;

public class UserDaoImpl implements UserDao
{

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource)
    {
        super();
        this.dataSource = dataSource;
    }

    public void add(User user)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "insert into user(id,name,password,fax,cellphone,address,email) values(?,?,?,?,?,?,?)";
            Object params[] = {user.getId(), user.getName(), user.getPassword(), user.getPhone(), user.getCellphone(),
                user.getAddress(), user.getEmail()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public User find(String name, String password)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from user where name=? and password=?";
            Object params[] = {name, password};
            return (User) runner.query(sql, params, new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public User find(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from user where id=?";
            return (User) runner.query(sql, id, new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

}
