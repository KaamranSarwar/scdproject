package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This itemContainer Class is used to store the information of items.
 * items can be added and removed from this container.
 */

public abstract class ItemContainer {
    protected int id;
    protected List<Item> items;

    /**
     *Used to add item in container.
     * @param i Item to be added in container.
     */
    public void addItem(Item i)
    {
        items.add(i);
    }

    /**
     * Used to remove item from container.
     * @param i item to be removed.
     */
    public void removeItem(Item i)
    {
        items.remove(i);
    }

    /**
     *Get id of container
     * @return id of this container.
     */

    public int getId() {
        return id;
    }

    /**
     * it updates the quantity of item by adding the quantity of item passed to its own quantity.
     * @param i item of which quantity to be added.
     */

    public void update(Item i)
    {
        for(Item item : items)
        {
            if(item.getProduct().getId() == i.getProduct().getId())
            {
                item.setQuantityOrdered(item.getQuantityOrdered() + i.getQuantityOrdered());
                return;
            }
        }
    }

    /**
     * Get all items in the container.
     * @return items in the container.
     */

    public List<Item> getItems() {
        return items;
    }

    /**
     * get total amount
     * @return total amount of all items in the container.
     */

    public abstract double getTotal();

}
