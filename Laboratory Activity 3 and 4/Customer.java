public class Customer {
    private String name;
    private int points;
    private static int totalCustomers = 0;

    public Customer() {
        this.name = "Unknown";
        this.points = 0;
        totalCustomers++;
    }

    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
        totalCustomers++;
    }

    public void addPoints(int points) {
        this.points += points;
        System.out.println(this.name + " earned " + points + " points. Total points: " + this.points);
    }

    public void redeemReward() {
        if (this.points >= 100) {
            this.points -= 100;
            System.out.println("Congratulations " + this.name + "! You redeemed a free drink!");
            System.out.println("Remaining Points: " + this.points);
            System.out.println();
        } else {
            System.out.println(this.name + " does not have enough points to redeem a drink.");
            System.out.println();
        }
    }

    public void displayCustomerInfo() {
        System.out.println("Customer: " + this.name);
        System.out.println("Points: " + this.points);
        System.out.println("-------------------------");
    }

    public static void displayTotalCustomers() {
        System.out.println("Total Registered Customers: " + totalCustomers);
    }

    public static void getAllowedRewardsRedemption(Customer customer) {
        int rewards = customer.points / 100;
        System.out.println(customer.name + " can redeem " + rewards + " reward(s).");
    }

}
