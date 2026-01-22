public class CoffeeShop {
    public static void main(String[] args) {
        Customer Joseph = new Customer("Joseph", 200);
        Customer Peter = new Customer("Peter", 0);
        Customer customer3 = new Customer();


        Peter.addPoints(200);
        Peter.addPoints(20);
        System.out.println();

        Joseph.redeemReward();
        Peter.redeemReward();
        customer3.redeemReward();

        System.out.println("=== Customer Information ===");
        Joseph.displayCustomerInfo();
        Peter.displayCustomerInfo();
        customer3.displayCustomerInfo();
        Customer.displayTotalCustomers();

        Customer Diane = new Customer("Diane", 0);
        Diane.addPoints(50);
        Diane.displayCustomerInfo();
        Customer.displayTotalCustomers();

        Customer.getAllowedRewardsRedemption(Joseph);
        Customer.getAllowedRewardsRedemption(Peter);
        Customer.getAllowedRewardsRedemption(customer3);
        Customer.getAllowedRewardsRedemption(Diane);
    }
}
