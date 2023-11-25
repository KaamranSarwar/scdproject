import DAO.CategoryDAO;
import DAO.ProductDAO;
import GUI.CategoryGUI;
import GUI.addUserUI;
import Model.Category;
import Model.Product;
import Model.User;

public class Main {
    public static void main(String[] args) {
      /*  Category category1 = new Category(1, "Electronics", "Electronic Devices", 0);
        Category category2 = new Category(2, "Clothing", "Fashion Apparel", 0);
        Category subcategory1_1 = new Category(11, "Smartphones", "Mobile Phones", 1);
        Category subcategory1_2 = new Category(12, "Laptops", "Personal Computers", 1);
        Category subcategory1_3 = new Category(13, "Headphones", "Audio Devices", 1);
        Category subcategory2_1 = new Category(21, "Men's Clothing", "Men's Fashion", 2);
        Category subcategory2_2 = new Category(22, "Women's Clothing", "Women's Fashion", 2);
        category1.addComponent(subcategory1_1);
        category1.addComponent(subcategory1_2);
        category1.addComponent(subcategory1_3);
        category2.addComponent(subcategory2_1);
        category2.addComponent(subcategory2_2);
        Product product1 = new Product(101, "iPhone 13", "Latest iPhone", 50, 1099.99, 11);
        Product product2 = new Product(102, "Dell XPS 13", "Powerful Laptop", 30, 1299.99, 12);
        Product product3 = new Product(103, "Sony WH-1000XM4", "Noise Cancelling Headphones", 20, 299.99, 13);
        Category subcategory1_1_1 = new Category(111, "Samsung", "Mobile Phones Company", 11);
        Category subcategory1_1_2 = new Category(112, "Apple", "Mobile Phones Company", 11);
        Category subcategory1_1_1_1 = new Category(1111, "Note8", "Note series", 111);
        Category subcategory1_1_1_2 = new Category(1112, "S10", "S series", 111);
        Category subcategory1_1_2_1 = new Category(1121, "iphone 15 pro", "i phone", 112);
        //CategoryDAO.addCategory(subcategory1_1_1);
        //CategoryDAO.addCategory(subcategory1_1_2);
        //CategoryDAO.addCategory(subcategory1_1_1_1);
        //CategoryDAO.addCategory(subcategory1_1_1_2);
        //CategoryDAO.addCategory(subcategory1_1_2_1);










        Product product4 = new Product(201, "Men's Shirt", "Casual Shirt for Men", 100, 29.99, 21);
        Product product5 = new Product(202, "Women's Dress", "Elegant Dress for Women", 80, 49.99, 22);
        Product product6 = new Product(203, "Men's Jeans", "Comfortable Jeans for Men", 120, 39.99, 21);
        subcategory1_1.addComponent(product1);
        subcategory1_2.addComponent(product2);
        subcategory1_3.addComponent(product3);

        subcategory2_1.addComponent(product4);
        subcategory2_2.addComponent(product5);
        subcategory2_1.addComponent(product6);


        category1.display();
        category2.display();
        CategoryDAO.addCategory(category1);
        CategoryDAO.addCategory(category2);
        CategoryDAO.addCategory(subcategory1_1);
        CategoryDAO.addCategory(subcategory1_2);
        CategoryDAO.addCategory(subcategory1_3);
        CategoryDAO.addCategory(subcategory2_1);
        CategoryDAO.addCategory(subcategory2_2);
        ProductDAO.addProduct(product1);
        ProductDAO.addProduct(product2);
        ProductDAO.addProduct(product3);
        ProductDAO.addProduct(product4);
        ProductDAO.addProduct(product5);
        ProductDAO.addProduct(product6);
        CategoryDAO.deleteCategory(2);
        ProductDAO.deleteProduct(202);*/
        //new CategoryGUI().setVisible(true);
        User u=new User();
        new addUserUI(u);

    }
}
