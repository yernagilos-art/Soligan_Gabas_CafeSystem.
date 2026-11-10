public abstract class MenuItem {
    protected String name;
    protected double price;
    private String itemCode;

    /**
     * This well create a menu item with default values of the name: the name "Unnamed Item",
     * a base price of 0.0, and also the item code "N/A".
     *
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.price = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Create a menu item on a given information.
     *
     * @param name     the name of it"s the item
     * @param price    the started price of the item
     * @param itemCode the item's identification code
     */
    public MenuItem(String name, double price, String itemCode) {
        setName(name);
        setBasePrice(price);
        setItemCode(itemCode);
    }

    /**
     * Returns its  name of this menu item.
     *
     * @return the items on its name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the a price on  this menu item, before any size or extra fees.
     *
     * @return a price
     */
    public double getBasePrice() {
        return price;
    }

    /**
     * Returns the item code that identifies this menu
     *
     * @return the item code, such as "B-01"
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Returns the item's name and code.
     *
     * @return the item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Sets the name of this menu item.
     *
     * @param name the new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the base price of the item.
     *
     * @param basePrice the new price
     */
    public void setBasePrice(double basePrice) {
        // When the base price is below zero, it will print out an error message
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.price = basePrice;
        }
    }

    /**
     * Sets a item code that identifies this menu item.
     *
     * @param itemCode the new item code, such as "B-01"
     */

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of the menu item.
     * Each subclass provides its own pricing implementation.
     *
     * @return the final calculated price
     */
    public abstract double computePrice();
}
