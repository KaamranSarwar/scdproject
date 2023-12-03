package Test;

import Model.Item;
import Model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getQuantityOrdered() {
        Item item = new Item(new Product(1,"panadol",2.0),10);
        assertEquals(10,item.getQuantityOrdered());
    }

    @Test
    void setQuantityOrdered() {
        Item item = new Item(new Product(1,"panadol",2.0),10);
        item.setQuantityOrdered(5);
        assertEquals(5,item.getQuantityOrdered());

    }

    @Test
    void getTotal() {
        Item item = new Item(new Product(1,"panadol",2.0),10);
        assertEquals(20.0,item.getTotal());

    }

    @Test
    void getProduct() {
        Item item = new Item(new Product(1,"panadol",2.0),10);
        assertNotNull(item.getProduct());
    }
}