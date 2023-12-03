package Test;

import DAO.OrderDAO;
import Model.Item;
import Model.Order;
import Model.Product;
import org.junit.jupiter.api.Test;

import java.sql.SQLData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    @Test
    void getLatestID() {
        List<Order> orders=OrderDAO.getOrdersWithItems();
        int id=OrderDAO.getLatestID();
        Order o= orders.get(id - 2);
        assertEquals(o.getId()+1,id);
    }

    @Test
    void addOrder() throws SQLException {
        int id=OrderDAO.getLatestID();
        Item testitem=new Item(new Product(1024,"test product",22.5),3);
        List<Item> itemList=new ArrayList<>();
        itemList.add(testitem);
        Order testorder=new Order(itemList,"test cust",id);
        OrderDAO.addOrder(testorder);
        int newid=OrderDAO.getLatestID();
        assertEquals(id+1,newid);
        OrderDAO.deleteOrder(newid-1);
    }

    @Test
    void getOrdersWithItems() {
        List<Order> orders=OrderDAO.getOrdersWithItems();
        assertFalse(orders.isEmpty());
    }

    @Test
    void getOrdersWithItemsOnDate() throws ParseException {

    }

    @Test
    void getOrdersBetweenDates() {
    }
}