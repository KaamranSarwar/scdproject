package Model;

/**
 * This item class is used to store the information of items bought by customer.
 * it includes the product and the quantity ordered by customer.
 */
public class Item {
    private Product product;
    private int quantityOrdered;

    /**
     * Construct an item.
     * @param product product of item.
     * @param quantityOrdered quantity ordered by customer of item.
     */

    public Item(Product product, int quantityOrdered) {
        this.product = product;
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * Get quantity ordered by customer.
     * @return quantity ordered.
     */

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets quantity ordered.
     * @param quantityOrdered quantity ordered by customer.
     */

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * Used to get to total amount of item that is purchased by customer.
     * @return total amount of item.
     */

    public double getTotal()
    {
        return product.getPrice()*quantityOrdered;
    }

    /**
     * Get product of item.
     * @return product of item.
     */

    public Product getProduct() {
        return product;
    }
}
