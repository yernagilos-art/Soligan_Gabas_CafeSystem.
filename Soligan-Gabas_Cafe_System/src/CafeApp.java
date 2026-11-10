/**
 * This is the main class of the university Cafe program.
 * It creates customers, menu items, and orders, then prints their receipts.
 *
 * @author Denzemiel Ethan S. Dacillo
 * @author Denemiel Nathan S. Dacillo
 * @version 1.0
 */


public class CafeApp {

    /**
     * Runs the Cafe program and shows sample customer orders.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args){

        System.out.println("------Cafe App------");



        System.out.print("Setter Error | ");



        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");
        Customer customer3 = new Customer("Kyle Rais");


        Beverage beverage = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry pastry = new Pastry("Ensaymada", 45, "P-01", true);
        Meal meal = new Meal("Chicken Adobo", 110, "M-01", true, 1);



        Beverage beverage1 = new Beverage();
        {
            beverage1.setName("Hot Chocolate");
            beverage1.setItemCode("B-02");
            beverage1.setSize("M");
            beverage1.setBasePrice(-5);
            beverage1.setBasePrice(80);
        }

        Pastry pastry1 = new Pastry();
        {
            pastry1.setName("Cookie");
            pastry1.setItemCode("P-02");
            pastry1.setBasePrice(30);
        }

        Meal meal1 = new Meal();
        {
            meal1.setName("Beef Tapa");
            meal1.setItemCode("M-02");
            meal1.setBasePrice(130);
            meal1.setUpsized(false);
            meal1.setExtraSides(0);
        }

        Order order1 = new Order("1001", customer1);
        order1.addItem(beverage);
        order1.addItem(pastry);
        order1.addItem(meal);
        order1.addItem(pastry1);
        order1.printReceipt();

        System.out.println("\n");

        Order order2 = new Order("1002", customer2);
        order2.addItem(beverage1);
        order2.addItem(meal1);
        order2.printReceipt(20);

        System.out.println("\n");

        Order order3 = new Order("1003", customer3);
        order3.addItem(beverage1);
        order3.addItem(pastry1);
        order3.printReceipt();

        System.out.println("\n");





    }
}