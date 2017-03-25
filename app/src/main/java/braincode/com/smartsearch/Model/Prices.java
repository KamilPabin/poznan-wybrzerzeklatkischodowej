package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Prices {
    private BuyNow buyNow;
    private WithDelivery withDelivery;

    public BuyNow getBuyNow() {
        return buyNow;
    }

    public WithDelivery getWithDelivery() {
        return withDelivery;
    }

    public class BuyNow {
        private double amount;

        public BuyNow(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "BuyNow{" +
                    "amount=" + amount +
                    '}';
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

        @Override
        public String toString() {
            return "WithDelivery{" +
                    "amount=" + amount +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Prices{" +
                "buyNow=" + buyNow +
                ", withDelivery=" + withDelivery +
                '}';
    }
}
