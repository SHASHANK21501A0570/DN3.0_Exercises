public class AdapterPatternExample {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    public static class PayPal {
        public void transfer(double amount) {
            System.out.println("PayPal: Transferring $" + amount);
        }
    }

    public static class Stripe {
        public void executePayment(double amount) {
            System.out.println("Stripe: Executing payment of $" + amount);
        }
    }

    public static class Square {
        public void bill(double amount) {
            System.out.println("Square: Billing $" + amount);
        }
    }

    public static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.transfer(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.executePayment(amount);
        }
    }

    public static class SquareAdapter implements PaymentProcessor {
        private Square square;

        public SquareAdapter(Square square) {
            this.square = square;
        }

        @Override
        public void processPayment(double amount) {
            square.bill(amount);
        }
    }

    public static void main(String[] args) {
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        PaymentProcessor squareProcessor = new SquareAdapter(square);

        System.out.println("Processing payments:");
        payPalProcessor.processPayment(150.0);
        stripeProcessor.processPayment(250.0);
        squareProcessor.processPayment(350.0);
    }
}
