public class StrategyPatternExample {

    public interface PaymentStrategy {
        void pay(double amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;

        public CreditCardPayment(String cardNumber, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using Credit Card: " + cardNumber);
        }
    }

    public static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using PayPal: " + email);
        }
    }

    public static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            if (paymentStrategy != null) {
                paymentStrategy.pay(amount);
            } else {
                System.out.println("Payment strategy not set");
            }
        }
    }

    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1564-5788-9126-5434", "Jane Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(123.0);

        PaymentStrategy payPalPayment = new PayPalPayment("kadiyala.shashank@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(789.0);
    }
}
