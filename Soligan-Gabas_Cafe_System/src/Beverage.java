/**
 * This class Represents a beverage available in the university Cafe.
 * The price changes depending on the selected size (S, M, or L).
 * @author Denemiel Nathan S. Dacillo
 * @version 1.0
 *
 */

public class Beverage extends MenuItem {
    private String size;
    /**
     * this Creates a beverage with default values and small size.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Creates a beverage with its name, price, item code, and size.
     *
     * @param name name of the beverage
     * @param basePrice original price of the beverage
     * @param itemCode assigned code of the beverage
     * @param size size selected (S, M, or L)
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }
    /**
     * Gets the current size of the beverage.
     *
     * @return the beverage size
     */
    public String getSize() {
        return size;
    }
    /**
     * Changes the beverage size.
     * The size must be S, M, or L.
     *
     * @param size new size to be assigned
     */
    public void setSize(String size) {
        // Medium adds 15, large adds 25, and small uses the base price
        if(size.equals("S") || size.equals("M") || size.equals("L"))
        {
            this.size = size;
        }
        else
        {
            System.out.println("Only Accepts Small, Medium, and Large");
        }

    }
    /**
     * Computes the total price of the beverage.
     * Medium has an additional 15 pesos, while large has 25 pesos.
     *
     * @return the total beverage price
     */
    @Override
    public double computePrice() {
        // Accept only the three valid sizes; otherwise reject the value and keep the old one
        if (size.equals("M")) {
            return price + 15;
        } else if (size.equals("L")) {
            return price + 25;
        } else {
            return price;
        }

    }
    /**
     * Gets the beverage details, including its selected size.
     *
     * @return beverage name, item code, and size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;

    }
}

