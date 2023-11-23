package Model;

import java.util.ArrayList;
import java.util.List;

public class Category implements Component {
    private final int Id;
    private String name;
    private String description;
    List<Component> subComponents;
    private int parentID;

    public Category(int id, String name, String description, int parentID) {
        Id = id;
        this.name = name;
        this.description = description;
        this.parentID = parentID;
        subComponents = new ArrayList<>();
    }



    public void addComponent(Component component) {
        subComponents.add(component);
    }

    public void removeComponent(Component component) {
        subComponents.remove(component);
    }

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
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
