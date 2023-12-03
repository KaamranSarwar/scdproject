package Model;

import DAO.OrderDAO;

import java.util.ArrayList;

/**
 * This class is used to store the items ordered by customer.
 * it extends the item container class.
 * items can be added and removed from this cart.
 */
public class Cart extends ItemContainer{
    /**
     * Constructs the cart having the newest available ID in the database table.
     */
    public Cart()
    {
        id = OrderDAO.getLatestID();
        items = new ArrayList<>();
    }

    /**
     * Retrieve a particular item in the cart.
     * @param id id of item.
     * @return item.
     */
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

    /**
     * used to get the total price of items in the cart.
     * @return total price.
     */
    @Override
    public double getTotal() {
        double total = 0.0;
        for(Item i : items)
        {
            total += i.getTotal();
        }
        return (int)Math.round(total);
    }

    /**
     * Used to remove all the items in the Cart.
     */
    public void clear()
    {
        items.clear();
    }

    /**
     * Used to generate the order of items in the cart.
     * @param n Customer name who bought these items.
     * @return Order containing all the items.
     */
    public Order generateOrder(String n)
    {
        return new Order(items,n,id);
    }


}
