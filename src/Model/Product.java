package Model;
import java.util.Date;

/**
 * Product class is used to Store information related to the products.
 *
 */
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

    /**
     * Get quantity in the packet.
     * @return quantity in the packet.
     */

    public int getQuantityInPack() {
        return QuantityInPack;
    }

    /**
     * Sets quantity in the packet.
     * @param quantityInPack quantity in the packet.
     */

    public void setQuantityInPack(int quantityInPack) {
        QuantityInPack = quantityInPack;
    }

    /**
     * Get total packets.
     * @return total packets.
     */

    public int getTotalPacks() {
        return totalPacks;
    }

    /**
     * Sets total packets.
     * @param totalPacks total packets.
     */

    public void setTotalPacks(int totalPacks) {
        this.totalPacks = totalPacks;
    }

    /**
     * Get Expire date of product.
     * @return Expire date.
     */

    public Date getExpDate() {
        return ExpDate;
    }

    /**
     * Sets Expire date of product.
     * @param expDate Expire date.
     */

    public void setExpDate(Date expDate) {
        ExpDate = expDate;
    }

    /**
     * Constructs the products with the following attributes.
     * @param id id of product.
     * @param name name of product.
     * @param price price of product.
     * @param quantityInPack quantity in the packet of product.
     * @param totalPacks total packets of product.
     * @param totalQuantity total quantity of product.
     * @param expDate expire date of product.
     * @param description description of product.
     * @param categoryID Category id of product.
     */

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

    /**
     * Constructs Product with the attributes' id,name and price.
     * Used for the Product contained in the Item.
     * @param id id of product.
     * @param name name of product.
     * @param price price of product.
     */
    public Product(int id, String name, double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Set Category ID of Product
     * @param categoryID Category ID.
     */


    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Set Description of product.
     * @param description description.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets name of product.
     * @param name name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price of product.
     * @param price price.
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets Total quantity of product.
     * @param totalQuantity Total quantity.
     */

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /**
     * Get the price of product.
     * @return price of product.
     */

    public double getPrice() {
        return price;
    }

    /**
     * Get the id of product.
     * @return id of product.
     */

    public int getId() {
        return Id;
    }

    /**
     * Get total quantity of product.
     * @return quantity of product.
     */

    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * Get the description of product.
     * @return description of product.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Get the name of product.
     * @return name of product.
     */

    public String getName() {
        return name;
    }

    /**
     * Get the Category id of product.
     * @return category id.
     */

    public int getCategoryID() {
        return categoryID;
    }

    /**
     * Display attributes of the product.
     */

    @Override
    public void display() {
        System.out.println("Name : " + name );
        System.out.println("price : " + price);
    }
}
