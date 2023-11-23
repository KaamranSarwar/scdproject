package Model;

public class Item {
    Product product;
    int quantityOrdered;

    public Item(Product product, int quantityOrdered) {
        this.product = product;
        this.quantityOrdered = quantityOrdered;
    }
    public double getTotal()
    {
        return product.getPrice()*quantityOrdered;
    }

}
