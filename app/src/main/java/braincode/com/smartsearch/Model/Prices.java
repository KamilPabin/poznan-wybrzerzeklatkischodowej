package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Prices {
    private BuyNow buyNow;

    public class BuyNow {
        private double amount;

        public BuyNow(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    public class WithDelivery {
        private double amount;

        public WithDelivery(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }
}
