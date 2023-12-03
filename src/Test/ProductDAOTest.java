package Test;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    @Test
    void addProduct() {
        Product p = new Product(999999,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        List<Product> products = ProductDAO.getAllProducts();
        ProductDAO.deleteProduct(p.getId());
        assertFalse(products.isEmpty());
    }

    @Test
    void getLowQuantityProducts() {

        Product p = new Product(999999,"panadol",2.5,5,1,5,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        List<Product> products = ProductDAO.getLowQuantityProducts();
        ProductDAO.deleteProduct(p.getId());
        assertFalse(products.isEmpty());


    }

    @Test
    void deleteProduct() {
        Product p = new Product(999999,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        ProductDAO.deleteProduct(p.getId());
        List<Product> products = ProductDAO.getAllProducts();
        assertFalse(products.contains(p));

    }

    @Test
    void deleteSoldProducts() {
        Product p = new Product(999999,"panadol",2.5,1,0,0,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        ProductDAO.deleteSoldProducts();
        List<Product> products = ProductDAO.getAllProducts();
        assertFalse(products.contains(p));

    }


    @Test
    void checkID() {
        Product p = new Product(999999,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        assertTrue(ProductDAO.checkID(p.getId()));
        ProductDAO.deleteProduct(p.getId());

    }

    @Test
    void getAllProducts() {
        Product p = new Product(999999,"panadol",2.5,10,5,50,new Date(),"pain relief",3);
        ProductDAO.addProduct(p);
        List<Product> products = ProductDAO.getAllProducts();
        assertFalse(products.isEmpty());
        ProductDAO.deleteProduct(p.getId());


    }

}