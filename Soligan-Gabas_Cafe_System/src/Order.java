/**
 * This class handles customer orders in the university Cafe.
 * It stores the ordered items and calculates the total amount to pay.
 * @author Denzemiel Ethan S. Dacillo
 * @version 1.0
 *
 */
public class Order {
    private Customer customer;
    private MenuItem item1, item2, item3;
    private int itemCount;
    private String orderId;
    /**
     * Creates a new order for a customer using an order ID.
     *
     * @param orderId ID assigned to the order
     * @param customer customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.itemCount = 0;
        setOrderId(orderId);
        setCustomer(customer);
    }
    /**
     * Gets the customer who placed the order.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * Sets the customer for this order.
     *
     * @param customer customer to be assigned
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * Gets the order ID.
     *
     * @return the order ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     *
     * @param orderId new ID for the order
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    /**
     * Gets the current number of items in the order.
     *
     * @return number of items added
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Adds an item to the order.
     * A maximum of three items can be added.
     *
     * @param item menu item to be added
     * @return true if the item was added, otherwise false
     */
    // Put the item in the first available slot. The order is full when all three are occupied.
    public boolean addItem(MenuItem item) {
        if (item1 == null) {
            this.item1 = item;
            itemCount += 1;
            return true;
        } else if (item2 == null) {
            this.item2 = item;
            itemCount += 1;
            return true;
        } else if (item3 == null) {
            this.item3 = item;
            itemCount += 1;
            return true;
        } else {
            System.out.println("Only Three Orders can be place. Cannot add new item: " + item.getDescription());
            return false;
        }


    }
    /**
     * Calculates the subtotal of all items in the order.
     *
     * @return total price before discounts
     */

// Add the price of each item that has been added.
    public double computeSubtotal() {
        double subtotal = 0;
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Calculates the total amount after applying the student discount.
     * Students receive a 10% discount.
     *
     * @return total price after discount
     */

    // Give students a 10% discount.
    public double computeTotal() {
        double total = computeSubtotal();
        if (customer.isStudent() == true) {
            total *= .90;
        }
        return total;
    }

    /**
     * Calculates the total after subtracting a voucher.
     *
     * @param voucher amount to be deducted from the total
     * @return final amount to pay
     */

    // Do not let the final amount go below zero.
    public double computeTotal(double voucher) {
        double total = computeTotal();
        total -= voucher;
        if (total < 0) {
            System.out.println("Error: Total Cannot be Negative");
            return total = 0;
        } else {
            return total;
        }


    }
    /**
     * Prints the receipt without using a voucher.
     */

    public void printReceipt(){
        printReceipt(0);
    }
    /**
     * Prints the order receipt with the item details,
     * subtotal, discounts, voucher, and final total.
     *
     * @param voucher voucher amount to be deducted
     */

    public void printReceipt(double voucher) {
        double total = computeTotal();
        double vouch = computeTotal(voucher);
        double subtotal = computeSubtotal();
        double discount = subtotal - total;

        // Add the student label to the header when the customer is a student.
        if (customer.isStudent() == true) {
            System.out.println("Order #" + getOrderId() + " - " + customer.getName() + " (Student)");
        } else {
            System.out.println("Order #" + getOrderId() + " - " + customer.getName());
        }

        // Print an item only if its slot contains something.
        if (item1 != null) {
            System.out.println(item1.getDescription() + "............" + item1.computePrice());
        }
        if (item2 != null) {
            System.out.println(item2.getDescription() + "............" + item2.computePrice());
        }
        if (item3 != null) {
            System.out.println(item3.getDescription() + "............" + item3.computePrice());
        }
        System.out.println("Subtotal: " + subtotal);


        // Display the discount only for student customers.
        if(customer.isStudent()){
            System.out.println("Student discount (10%): -" + discount);
        }

        // Show the voucher deduction only when a voucher is used.
        if(voucher > 0) {
            System.out.println("Voucher: -" + voucher);
        }
        System.out.println("Total: " + vouch);



        customer.addPoints(vouch);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());

    }
}