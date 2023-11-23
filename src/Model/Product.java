package Model;
public class Product implements Component {
    private final int Id;
    private String name;
    private String description;
    private int stockQuantity;
    private double price;
    private int categoryID;
    public Product(int id, String name, String description, int stockQuantity, double price, int categoryID) {
        Id = id;
        this.name = name;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.categoryID = categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return Id;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    @Override
    public void display() {
        System.out.println("Name : " + name );
        System.out.println("price : " + price);
    }
}
