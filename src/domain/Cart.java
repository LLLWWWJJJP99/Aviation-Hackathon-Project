package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart
{
	private String id;
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private Map map = new HashMap();

    private double totalprice = 0;

    public void add(Product product)
    {
        CartItem item = (CartItem) map.get(product.getId());
        if (item == null) {
            item = new CartItem();
            item.setProduct(product);
            item.setQuantity(1);
            map.put(product.getId(), item);
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public double getTotalprice()
    {

        this.totalprice = 0;

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            CartItem item = (CartItem) map.get(it.next());
            this.totalprice = this.totalprice + item.getTotalprice();
        }
        return totalprice;
    }

    public void setTotalprice(double totalprice)
    {
        this.totalprice = totalprice;
    }

}
