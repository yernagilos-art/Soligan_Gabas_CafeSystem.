/**
 * This class represents pastries available in the university Cafe.
 * Customers can choose whether they want their pastry warmed or not.
 * @author Rey Soligan
 * @version 1.0
 *
 */

public class Pastry extends MenuItem {
    private boolean warmed;
    /**
     * Creates a pastry with default values.
     * By default, the pastry is not warmed.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }
    /**
     * Creates a pastry using the given details.
     *
     * @param name name of the pastry
     * @param basePrice original price of the pastry
     * @param itemCode assigned code of the pastry
     * @param warmed tells whether the pastry is warmed or not
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        setWarmed(warmed);
    }
    /**
     * Checks if the pastry is warmed.
     *
     * @return true if warmed, otherwise false
     */
    public boolean isWarmed() {
        return warmed;
    }
    /**
     * Sets the warmed status of the pastry.
     *
     * @param warmed the new warmed status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }

    /**
     * Calculates the price of the pastry.
     * An additional 10 pesos is added if it is warmed.
     *
     * @return the final price of the pastry
     */
    @Override
    public double computePrice() {
        // Add 10 pesos if the pastry is warmed.
        if (warmed){
            return price + 10;
        }
        return price;
    }
    /**
     * Gets the pastry details and includes its warmed status.
     *
     * @return the pastry description
     */
    @Override

    public String getDescription() {
        // Show the warmed label only if the pastry is warmed.
        if(warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }
}