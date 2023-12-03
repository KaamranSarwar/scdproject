package Test;

import Model.Cart;
import Model.Item;
import Model.Order;
import Model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void getItem() {
        Item i= new Item(new Product(1,"panadol",2.0),2);
        Item i1 =new Item(new Product(2,"brufen",3.0),3);
        Cart cart = new Cart();
        cart.addItem(i);
        cart.addItem(i1);
        assertNotNull(cart.getItem(1));
    }

    @Test
    void getTotal() {
        Item i= new Item(new Product(1,"panadol",2.0),2);
        Item i1 =new Item(new Product(2,"brufen",3.0),3);
        Cart cart = new Cart();
        cart.addItem(i);
        cart.addItem(i1);

        assertEquals(13.0,cart.getTotal());
    }

    @Test
    void clear() {
        Item i= new Item(new Product(1,"panadol",2.0),2);
        Item i1 =new Item(new Product(2,"brufen",3.0),3);
        Cart cart = new Cart();
        cart.addItem(i);
        cart.addItem(i1);
        cart.clear();
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void generateOrder() {
        Item i= new Item(new Product(1,"panadol",2.0),2);
        Item i1 =new Item(new Product(2,"brufen",3.0),3);
        Cart cart = new Cart();
        cart.addItem(i);
        cart.addItem(i1);
        assertNotNull(cart.generateOrder("kami"));

    }
}