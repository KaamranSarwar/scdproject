package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the information of categories of product.
 * A category can also have sub category.
 */

public class Category implements Component {
    private final int Id;
    private String name;
    private String description;
    List<Component> subComponents;
    private int parentID;

    /**
     * Constructs the category.
     * @param id id of category.
     * @param name name of category.
     * @param description description of category.
     * @param parentID parent of category.
     */
    public Category(int id, String name, String description, int parentID) {
        Id = id;
        this.name = name;
        this.description = description;
        this.parentID = parentID;
        subComponents = new ArrayList<>();
    }

    /**
     * Used to add sub category or product.
     * @param component sub category of a category or a product.
     */

    public void addComponent(Component component) {
        subComponents.add(component);
    }

    /**
     * Used to remove sub category or product.
     * @param component sub category or product.
     */

    public void removeComponent(Component component) {
        subComponents.remove(component);
    }

    /**
     * Display the All the categories and sub categories.
     * Also displays products in those categories.
     */

    @Override
    public void display() {
        System.out.println("ID: " + Id);
        System.out.println("Category: " + name);
        System.out.println("Description " + description);
        System.out.println("ParentID: " + parentID);

        for (Component component : subComponents) {
            component.display();
        }
    }

    /**
     * Get id of category.
     * @return id of category.
     */
    public int getId() {
        return Id;
    }

    /**
     * Get the name of category.
     * @return name of category.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of category.
     * @param name  name of category.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the description of category.
     * @return description of category.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of category.
     * @param description description of category.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the id of parent category.
     * @return id of parent category.
     */

    public int getParentID() {
        return parentID;
    }

    /**
     * Sets the id of parent category.
     * @param parentID id of parent category.
     */

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
