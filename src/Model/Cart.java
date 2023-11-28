package Model;

import DAO.OrderDAO;

import java.util.ArrayList;

public class Cart extends ItemContainer{
    public Cart()
    {
        id = OrderDAO.getLatestID();
        items = new ArrayList<>();
    }
    public Item getItem(int id)
    {
        for(Item i : items)
        {
            if(i.getProduct().getId() == id)
            {
                return i;
            }
        }
        return null;
    }
    @Override
    public double getTotal() {
        double total = 0.0;
        for(Item i : items)
        {
            total += i.getTotal();
        }
        return (int)Math.round(total);
    }
    public void clear()
    {
        items.clear();
    }
    public Order generateOrder(String n)
    {
        return new Order(items,n,id);
    }


}
