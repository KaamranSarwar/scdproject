package Test;

import DAO.CategoryDAO;
import Model.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest {

    @org.junit.jupiter.api.Test
    void addCategory() {
        CategoryDAO.deleteCategory(1);
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        assertTrue(CategoryDAO.checkID(1));
        CategoryDAO.deleteCategory(1);
    }

    @org.junit.jupiter.api.Test
    void updateCategory() {
        CategoryDAO.deleteCategory(1);
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        testCategory.setName("update test category");
        CategoryDAO.updateCategory(testCategory);
        assertEquals("update test category",CategoryDAO.getName(1));
        CategoryDAO.deleteCategory(1);
    }

    @org.junit.jupiter.api.Test
    void deleteCategory() {
        CategoryDAO.deleteCategory(1);
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        CategoryDAO.deleteCategory(1);
        assertFalse(CategoryDAO.checkID(1));
        CategoryDAO.deleteCategory(1);
    }

    @org.junit.jupiter.api.Test
    void getAllCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategory();
        assertNotNull(categories);
        assertTrue(categories.size() > 0);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        assertEquals("Test Category",CategoryDAO.getName(1));
        CategoryDAO.deleteCategory(1);
    }

    @org.junit.jupiter.api.Test
    void getAllChilds() {
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        Category c2=new Category(1023,"test cat2 ","test category",1);
        CategoryDAO.addCategory(testCategory);
        CategoryDAO.addCategory(c2);
        assertEquals(1,CategoryDAO.getAllChilds(1).size());
        CategoryDAO.deleteCategory(1);
        CategoryDAO.deleteCategory(1023);
    }

    @org.junit.jupiter.api.Test
    void getID() {
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        assertEquals(1,CategoryDAO.getID(testCategory.getName()));
        CategoryDAO.deleteCategory(1);
    }

    @org.junit.jupiter.api.Test
    void checkID() {
        Category testCategory = new Category(1, "Test Category", "Test Description", 0);
        CategoryDAO.addCategory(testCategory);
        assertTrue(CategoryDAO.checkID(1));
        CategoryDAO.deleteCategory(1);
    }
}