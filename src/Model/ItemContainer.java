package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemContainer {
    protected int id;
    protected List<Item> items;
    public void addItem(Item i)
    {
        items.add(i);
    }
    public void removeItem(Item i)
    {
        items.remove(i);
    }

    public int getId() {
        return id;
    }

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

    public List<Item> getItems() {
        return items;
    }

    public abstract double getTotal();

}
