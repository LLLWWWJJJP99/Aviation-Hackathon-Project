package dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.OrderDao;
import dao.exception.DaoException;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import domain.User;

public class OrderDaoImpl implements OrderDao
{

    private DataSource dataSource;

    public OrderDaoImpl(DataSource dataSource)
    {
        super();
        this.dataSource = dataSource;
    }

    public void addOrder(Order order)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "insert into orders(id,ordertime,state,price,user_id) values(?,?,?,?,?) ";
            Object params[] =
                {order.getId(), order.getOrdertime(), order.isState(), order.getPrice(), order.getUser().getId()};
            runner.update(sql, params);

            Iterator it = order.getOrderitems().iterator();
            while (it.hasNext()) {
                OrderItem item = (OrderItem) it.next();
                String sql2 = "insert into orderitem(id,quantity,price,product_id,order_id) values(?,?,?,?,?)";
                params = new Object[] {item.getId(), item.getQuantity(), item.getPrice(), item.getProduct().getId(),
                    order.getId()};
                runner.update(sql2, params);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public Order find(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select id,ordertime,state,price from orders where id=?";
            Order order = (Order) runner.query(sql, id, new BeanHandler(Order.class));

            sql = "select user.* from orders,user where orders.id=? and user.id=orders.user_id";
            User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
            order.setUser(user);

            sql = "select orderitem.* from orders,orderitem where orders.id=? and orderitem.order_id=orders.id";
            List itemlist = (List) runner.query(sql, order.getId(), new BeanListHandler(OrderItem.class));
            Iterator it1 = itemlist.iterator();
            while (it1.hasNext()) {

                OrderItem oitem = (OrderItem) it1.next();
                sql =
                    "select product.* from orderitem,product where orderitem.id=? and orderitem.product_id=product.id";
                Product product = (Product) runner.query(sql, oitem.getId(), new BeanHandler(Product.class));
                oitem.setProduct(product);
            }
            order.getOrderitems().addAll(itemlist);
            return order;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public List getAll(boolean state)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select id,ordertime,state,price from orders where state=? order by ordertime desc";
            List list = (List) runner.query(sql, state, new BeanListHandler(Order.class));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                // �ҳ����������ĸ��û�
                Order order = (Order) it.next();
                sql = "select user.* from orders,user where orders.id=? and user.id=orders.user_id";
                User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
                order.setUser(user);

                // �ҳ�������������Ŀ
                sql = "select orderitem.* from orders,orderitem where orders.id=? and orderitem.order_id=orders.id";
                List itemlist = (List) runner.query(sql, order.getId(), new BeanListHandler(OrderItem.class));
                Iterator it1 = itemlist.iterator();
                while (it1.hasNext()) {

                    // �ҳ�ÿһ����Ŀ������ı���
                    OrderItem oitem = (OrderItem) it1.next();
                    sql =
                        "select product.* from orderitem,product where orderitem.id=? and orderitem.product_id=product.id";
                    Product product = (Product) runner.query(sql, oitem.getId(), new BeanHandler(Product.class));
                    oitem.setProduct(product);
                }
                order.getOrderitems().addAll(itemlist);
            }
            return list;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public void updateOrderState(String id)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "update orders set state=true where id=?";
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    // �ҳ��û����еĶ���
    public List find(User user1)
    {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            String sql = "select orders.* from orders where orders.user_id=?";
            List list = (List) runner.query(sql, user1.getId(), new BeanListHandler(Order.class));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                // �ҳ����������ĸ��û�
                Order order = (Order) it.next();
                sql = "select user.* from orders,user where orders.id=? and user.id=orders.user_id";
                User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
                order.setUser(user);

                // �ҳ�������������Ŀ
                sql = "select orderitem.* from orders,orderitem where orders.id=? and orderitem.order_id=orders.id";
                List itemlist = (List) runner.query(sql, order.getId(), new BeanListHandler(OrderItem.class));
                Iterator it1 = itemlist.iterator();
                while (it1.hasNext()) {

                    // �ҳ�ÿһ����Ŀ������ı���
                    OrderItem oitem = (OrderItem) it1.next();
                    sql =
                        "select product.* from orderitem,product where orderitem.id=? and orderitem.product_id=product.id";
                    Product product = (Product) runner.query(sql, oitem.getId(), new BeanHandler(Product.class));
                    oitem.setProduct(product);
                }
                order.getOrderitems().addAll(itemlist);
            }
            return list;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
