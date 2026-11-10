/**
 *
 * This class stores the information of a Cafe customer.
 * It also keeps track of their student status and loyalty points.
 * @author Denzemiel Ethan S. Dacillo
 * @version 1.0
 *
 */



public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;
    /**
     * Creates a customer with default values.
     */
    public Customer() {
        this.name = "Customer";
        this.student = false;
        this.loyaltyPoints = 0;
    }
    /**
     * Creates a customer using their name.
     * The student status is false by default.
     *
     * @param name name of the customer
     */
    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name name of the customer
     * @param student tells whether the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        setStudent(student);
        setLoyaltyPoints(loyaltyPoints);
    }
    /**
     * Gets the customer's name.
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }
    /**
     * Checks if the customer is a student.
     *
     * @return true if the customer is a student
     */
    public boolean isStudent() {
        return student;
    }
    /**
     * Gets the current loyalty points of the customer.
     *
     * @return total loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
    /**
     * Adds loyalty points to the customer's account.
     * Negative points are not accepted.
     *
     * @param points number of points to add
     */

    public void addPoints(int points) {
        // Do not accept negative points.
        if (points < 0) {
            System.out.println("Error: points cannot be negative.");
        } else {
            loyaltyPoints += points;
        }

    }
    /**
     * Adds loyalty points based on the amount spent.
     * Every 50 pesos spent is equal to 1 point.
     *
     * @param amountSpent total amount spent by the customer
     */

    public void addPoints(double amountSpent){
        // Check the amount first, then convert every 50 pesos spent into 1 point.
        if(amountSpent < 0){
            System.out.println("Error: the amount spent cannot be negative");
        } else{
            addPoints ((int) (amountSpent / 50));
        }
    }
    /**
     * Changes the customer's name.
     *
     * @param name new name of the customer
     */

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Updates the customer's loyalty points.
     *
     * @param loyaltyPoints new number of loyalty points
     */

    public void setLoyaltyPoints(int loyaltyPoints) {
        // Only update the points if the given value is not negative.
        if(loyaltyPoints < 0) {
            System.out.println("Error: Loyalty points cannot be negative");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
    /**
     * Updates the customer's student status.
     *
     * @param student new student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }
}