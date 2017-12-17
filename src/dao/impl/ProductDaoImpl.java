package dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.ProductDao;
import dao.exception.DaoException;
import domain.Product;

public class ProductDaoImpl implements ProductDao
{

    private DataSource dataSource;

    public ProductDaoImpl(DataSource dataSource)
    {
        super();
        this.dataSource = dataSource;
    }

    public void addProduct(Product product)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql =
                "insert into product(id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
            Object params[] = {product.getId(), product.getName(), product.getAuthor(), product.getPrice(),
                product.getImage(), product.getDescription(), product.getCategory_id()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public Product find(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from product where id=?";
            return (Product) runner.query(sql, id, new BeanHandler(Product.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public List getProductByPage(String category_id, int startindex, int pagesize)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from product where category_id=? limit ?,?";
            Object params[] = {category_id, startindex, pagesize};
            return (List) runner.query(sql, params, new BeanListHandler(Product.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public int getTotalRecord(String category_id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select count(*) from product where category_id=?";
            Object result[] = (Object[]) runner.query(sql, category_id, new ArrayHandler());
            return Integer.parseInt(result[0].toString());
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public List getProductByPage(int startindex, int pagesize)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from product limit ?,?";
            Object params[] = {startindex, pagesize};
            return (List) runner.query(sql, params, new BeanListHandler(Product.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public int getTotalRecord()
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select count(*) from product";
            Object result[] = (Object[]) runner.query(sql, new ArrayHandler());
            return Integer.parseInt(result[0].toString());
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see dao.ProductDao#updateProduct(domain.Product)
     */
    @Override
    public void updateProduct(Product product)
    {
        // TODO Auto-generated method stub
        try {
            System.out.println(product.getAuthor() + "author");
            QueryRunner runner = new QueryRunner(dataSource);
            String sql =
                "update product set name = ?,author = ?,price = ?,image = ?,description = ? ,category_id =? where id =?";
            Object params[] = {product.getName(), product.getAuthor(), product.getPrice(), product.getImage(),
                product.getDescription(), product.getCategory_id(), product.getId()};
            runner.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see dao.ProductDao#deleteProduct(java.lang.String)
     */
    @Override
    public void deleteProduct(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "delete from product where id = ?";
            Object params[] = {id};
            runner.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DaoException(e.getMessage(), e);
        }

    }
}
