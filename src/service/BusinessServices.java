package service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dao.CategoryDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.SellerDao;
import dao.UserDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.ProductDaoImpl;
import dao.impl.SellerDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.Page;
import domain.Product;
import domain.Seller;
import domain.User;
import util.JdbcUtils;
import util.Utils;

public class BusinessServices
{

    public void addCategory(Category category)
    {
        CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
        dao.addCategory(category);
    }

    public List getALlCategory()
    {
        CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
        return dao.getAllCategory();
    }

    public void addProduct(Product product)
    {
        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        dao.addProduct(product);
    }

    public Page getProductByPage(String category_id, String pageNum)
    {

        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        int totalrecord = dao.getTotalRecord(category_id);
        Page page = null;

        if (pageNum == null) {
            page = new Page(totalrecord, 1);
        } else {
            page = new Page(totalrecord, Integer.parseInt(pageNum));
        }
        List list = dao.getProductByPage(category_id, page.getStartindex(), page.getPagesize());
        page.setList(list);
        return page;
    }

    public Page getProductByPage(String pageNum)
    {

        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        int totalrecord = dao.getTotalRecord();
        Page page = null;

        if (pageNum == null) {
            page = new Page(totalrecord, 1);
        } else {
            page = new Page(totalrecord, Integer.parseInt(pageNum));
        }
        List list = dao.getProductByPage(page.getStartindex(), page.getPagesize());
        page.setList(list);
        return page;
    }

    public void buyProduct(String productid, Cart cart)
    {

        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        Product product = dao.find(productid);
        cart.add(product);
    }

    public void addUser(User user)
    {

        UserDao dao = new UserDaoImpl(JdbcUtils.getDataSource());
        dao.add(user);
    }
    
    public void addSeller(Seller seller)
    {

        SellerDao dao = new SellerDaoImpl(JdbcUtils.getDataSource());
        dao.add(seller);
    }
    
    public User findUser(String name, String password)
    {
        UserDao dao = new UserDaoImpl(JdbcUtils.getDataSource());
        return dao.find(name, password);
    }
    
    public Seller findSeller(String name, String password)
    {
        SellerDao dao = new SellerDaoImpl(JdbcUtils.getDataSource());
        return dao.find(name, password);
    }

    public void addOrder(Cart cart, User user)
    {
        if (cart == null) {
            throw new IllegalArgumentException("Please Add More Products into Your Cart");
        }

        Order order = new Order();
        order.setId(Utils.makeId());
        order.setOrdertime(new Date());
        order.setPrice(cart.getTotalprice());
        order.setState(false);
        order.setUser(user);

        Set set = new HashSet();
        Iterator it = cart.getMap().keySet().iterator();
        while (it.hasNext()) {
            CartItem item = (CartItem) cart.getMap().get(it.next());
            OrderItem oitem = new OrderItem();
            oitem.setProduct(item.getProduct());
            oitem.setId(Utils.makeId());
            oitem.setPrice(item.getTotalprice());
            oitem.setQuantity(item.getQuantity());
            set.add(oitem);
        }
        order.setOrderitems(set);

        OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
        dao.addOrder(order);
    }

    public List getAllOrder(boolean state)
    {
        OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
        return dao.getAll(state);
    }

    public Order findOrder(String order_id)
    {
        OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
        return dao.find(order_id);
    }

    public Category findCategoryById(String categoryId)
    {
        CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
        return dao.findCategoryById(categoryId);

    }

    public void updateOrderState(String order_id)
    {
        OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
        dao.updateOrderState(order_id);
    }

    public List findUserOrder(User user)
    {
        OrderDao dao = new OrderDaoImpl(JdbcUtils.getDataSource());
        return dao.find(user);
    }

    /**
     * @param category
     */
    public void updateCategory(Category category)
    {
        CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
        dao.updateCategory(category);
    }

    /**
     * @param id
     * @return
     */
    public Product findProductById(String id)
    {
        // TODO Auto-generated method stub
        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        return dao.find(id);
    }

    /**
     * @param product
     */
    public void updateProduct(Product product)
    {
        // TODO Auto-generated method stub
        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        dao.updateProduct(product);
    }

    /**
     * @param id
     */
    public void deleteCategoryById(String id)
    {
        CategoryDao dao = new CategoryDaoImpl(JdbcUtils.getDataSource());
        dao.deleteCategoryById(id);

    }

    /**
     * @param id
     */
    public void deleteProductById(String id)
    {
        ProductDao dao = new ProductDaoImpl(JdbcUtils.getDataSource());
        dao.deleteProduct(id);

    }
}
