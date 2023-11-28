package Model;

public class Item {
    private Product product;
    private int quantityOrdered;

    public Item(Product product, int quantityOrdered) {
        this.product = product;
        this.quantityOrdered = quantityOrdered;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getTotal()
    {
        return product.getPrice()*quantityOrdered;
    }

    public Product getProduct() {
        return product;
    }
}
