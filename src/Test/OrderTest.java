package Test;

import Model.Item;
import Model.Order;
import Model.Product;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void setTimestamp() {
        Order order = new Order(null,"kami",1);
        order.setTimestamp(new Timestamp(new Date().getTime()));
        assertNotNull(order.getTimestamp());
    }

    @Test
    void setCustomerName() {
        Order order = new Order(null,"kami",1);
        order.setCustomerName("ahmad");
        assertEquals("ahmad",order.getCustomerName());
    }

    @Test
    void getTotal() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(new Product(1,"panadol",2.0),2));
        items.add(new Item(new Product(2,"brufen",3.0),3));
        Order order = new Order(items,"kami",1);
        assertEquals(13.0,order.getTotal());
    }

    @Test
    void getCustomerName() {
        Order order = new Order(null,"kami",1);
        assertEquals("kami",order.getCustomerName());


    }
    @Test
    void testUpdate()
    {
        List<Item> items = new ArrayList<>();
        Item i1 = new Item(new Product(1,"panadol",2.0),2);
        items.add(i1);
        items.add(new Item(new Product(2,"brufen",3.0),3));
        Order order = new Order(items,"kami",1);
        Item i = new Item(new Product(1,"panadol",2.0),3);
        order.update(i);
        assertEquals(5,i1.getQuantityOrdered());

    }

    @Test
    void getTimestamp() {
        Order order = new Order(null,"kami",1);
        assertNotNull(order.getTimestamp());

    }
}