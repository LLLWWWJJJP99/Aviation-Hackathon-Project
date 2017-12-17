package domain;

public class CartItem
{

    private Product product;

    private int quantity;

    private double totalprice;

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
        this.totalprice = this.product.getPrice() * this.quantity;
    }

    public double getTotalprice()
    {
        return totalprice;
    }

    public void setTotalprice(double totalprice)
    {
        this.totalprice = totalprice;
    }

}
