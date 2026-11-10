/**
 *
 *  This class represents meals available in the university Cafe.
 *  Customers can choose to upsize their meal and add extra sides.
 *
 * @author Rey Soligan
 * @version 1.0
 *
 */

public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;
    /**
     * Creates a meal with default values.
     * By default, the meal is regular with no extra sides.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }
    /**
     * Creates a meal using the given details and options.
     *
     * @param name name of the meal
     * @param basePrice original price of the meal
     * @param itemCode assigned code of the meal
     * @param upsized tells whether the meal is upsized or not
     * @param extraSides number of extra sides ordered
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        setUpsized(upsized);
        this.extraSides = 0;
        setExtraSides(extraSides);
    }
    /**
     * Gets the number of extra sides added to the meal.
     *
     * @return number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }
    /**
     * Checks if the meal is upsized.
     *
     * @return true if upsized, otherwise false
     */
    public boolean isUpsized() {
        return upsized;
    }
    /**
     * Sets the number of extra sides.
     * Negative values are not accepted.
     *
     * @param extraSides new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Extra sides cannot have a negative value.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative");
        }
    }
    /**
     * Changes the upsized status of the meal.
     *
     * @param upsized the new upsized status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }
    /**
     * Calculates the total price of the meal.
     * Upsizing adds 20 pesos, while each extra side adds 12 pesos.
     *
     * @return the final price of the meal
     */
    @Override

    public double computePrice() {
        // Add 20 pesos for upsizing and 12 pesos for each extra side.
        if (upsized) {
            return basePrice + 20 + 12 * extraSides;
        } else {
            return basePrice + 12 * extraSides;
        }

    }
    /**
     * Gets the meal details, including its size and extra sides.
     *
     * @return the meal description
     */
    @Override
    public String getDescription() {
        // Display whether the meal is regular or upsized.
        if (upsized) {
            return super.getDescription() + " Upsized, " + extraSides + " side/s";
        } else {
            return super.getDescription() + " Regular, " + extraSides + " side/s";
        }

    }
}