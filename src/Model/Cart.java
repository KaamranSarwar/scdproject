package Model;
import java.util.ArrayList;

public class Cart extends ItemContainer{
    public Cart()
    {
        items = new ArrayList<>();
    }
    @Override
    public double getTotal() {
        double total = 0.0;
        for(Item i : items)
        {
            total += i.getTotal();
        }
        return total;
    }
    public void clearCart()
    {
        items.clear();
    }


}
