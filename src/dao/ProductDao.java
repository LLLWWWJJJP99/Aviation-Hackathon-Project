package dao;

import java.util.List;

import domain.Product;

public interface ProductDao
{

    public void addProduct(Product product);

    public Product find(String id);

    public int getTotalRecord(String category_id);

    public List getProductByPage(String category_id, int startindex, int pagesize);

    public int getTotalRecord();

    public List getProductByPage(int startindex, int pagesize);

    /**
     * @param product
     */
    public void updateProduct(Product product);

    /**
     * @param id
     */
    public void deleteProduct(String id);

}
