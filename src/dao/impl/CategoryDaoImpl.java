package dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CategoryDao;
import dao.exception.DaoException;
import domain.Category;

public class CategoryDaoImpl implements CategoryDao
{

    private DataSource dataSource;

    public CategoryDaoImpl(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void addCategory(Category category)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "insert into category(id,name,description) values(?,?,?)";
            Object params[] = {category.getId(), category.getName(), category.getDescription()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public Category findCategoryById(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from category where id = ?";
            Object[] params = new Object[] {id};
            Category category = (Category) runner.query(sql, params, new BeanHandler(Category.class));
            return category;
        } catch (SQLException exception) {
            // TODO Auto-generated catch block
            throw new DaoException(exception);
        }
    }

    public List getAllCategory()
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select * from category";
            return (List) runner.query(sql, new BeanListHandler(Category.class));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void updateCategory(Category category)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "update category set name = ?,description = ? where id =?";
            Object params[] = {category.getName(), category.getDescription(), category.getId()};
            runner.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see dao.CategoryDao#deleteCategoryById(java.lang.String)
     */
    @Override
    public void deleteCategoryById(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "delete from category where id = ?";
            Object params[] = {id};
            runner.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DaoException(e.getMessage(), e);
        }
    }
}
