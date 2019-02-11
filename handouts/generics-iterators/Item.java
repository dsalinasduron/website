/**
 * A typical item that we purchase at a store.
 */
public class Item
{
    private String name;
    private int quantity;
    private double cost;

    public Item(String name, int quantity, double cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public double getTotalCost() {
        return quantity * cost;
    }
}
