package Model;
import java.util.Date;
public class Product implements Component {
    private final int Id;
    private String name;
    private double price;
    private int QuantityInPack;
    private int totalPacks;
    private int totalQuantity;
    private Date ExpDate;

    private String description;

    private int categoryID;

    public int getQuantityInPack() {
        return QuantityInPack;
    }

    public void setQuantityInPack(int quantityInPack) {
        QuantityInPack = quantityInPack;
    }

    public int getTotalPacks() {
        return totalPacks;
    }

    public void setTotalPacks(int totalPacks) {
        this.totalPacks = totalPacks;
    }

    public Date getExpDate() {
        return ExpDate;
    }

    public void setExpDate(Date expDate) {
        ExpDate = expDate;
    }

    public Product(int id, String name, double price, int quantityInPack, int totalPacks, int totalQuantity, Date expDate, String description, int categoryID) {
        Id = id;
        this.name = name;
        this.price = price;
        QuantityInPack = quantityInPack;
        this.totalPacks = totalPacks;
        this.totalQuantity = totalQuantity;
        ExpDate = expDate;
        this.description = description;
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

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return Id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
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
