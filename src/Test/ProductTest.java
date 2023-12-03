package Test;

import Model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getQuantityInPack() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(10,p.getQuantityInPack());
    }

    @Test
    void setQuantityInPack() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setQuantityInPack(5);
        assertEquals(5,p.getQuantityInPack());

    }

    @Test
    void getTotalPacks() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(5,p.getTotalPacks());

    }

    @Test
    void setTotalPacks() {

        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setTotalPacks(2);
        assertEquals(2,p.getTotalPacks());

    }

    @Test
    void getExpDate() {

        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertNotNull(p.getExpDate());
    }

    @Test
    void setExpDate() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setExpDate(new Date());
        assertNotNull(p.getExpDate());

    }

    @Test
    void setCategoryID() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setCategoryID(10);
        assertEquals(10,p.getCategoryID());
    }

    @Test
    void setDescription() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setDescription("pain");
        assertEquals("pain",p.getDescription());

    }

    @Test
    void setName() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setName("bruphen");
        assertEquals("bruphen",p.getName());
    }

    @Test
    void setPrice() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setPrice(22.3);
        assertEquals(22.3,p.getPrice());

    }

    @Test
    void setTotalQuantity() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        p.setTotalQuantity(4);
        assertEquals(4,p.getTotalQuantity());

    }

    @Test
    void getPrice() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(2.5,p.getPrice());

    }

    @Test
    void getId() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(1,p.getId());
    }

    @Test
    void getTotalQuantity() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(50,p.getTotalQuantity());
    }

    @Test
    void getDescription() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals("pain relief",p.getDescription());
    }

    @Test
    void getName() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals("panadol",p.getName());
    }

    @Test
    void getCategoryID() {
        Product p = new Product(1,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        assertEquals(3,p.getCategoryID());
    }
}