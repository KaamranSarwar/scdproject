package Test;

import Model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getId() {
        Category category = new Category(1,"medicine","something",2);
        assertEquals(1,category.getId());
    }

    @Test
    void getName() {

        Category category = new Category(1,"medicine","something",2);
        assertEquals("medicine",category.getName());
    }

    @Test
    void setName() {
        Category category = new Category(1,"medicine","something",2);
        category.setName("med");
        assertEquals("med",category.getName());
    }

    @Test
    void getDescription() {
        Category category = new Category(1,"medicine","something",2);
        assertEquals("something",category.getDescription());
    }

    @Test
    void setDescription() {
        Category category = new Category(1,"medicine","something",2);
        category.setDescription("some");
        assertEquals("some",category.getDescription());
    }

    @Test
    void getParentID() {
        Category category = new Category(1,"medicine","something",2);
        assertEquals(2,category.getParentID());
    }

    @Test
    void setParentID() {
        Category category = new Category(1,"medicine","something",2);
        category.setParentID(5);
        assertEquals(5,category.getParentID());
    }
}