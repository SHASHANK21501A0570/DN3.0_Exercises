import java.util.Arrays;

public class OrderSortExample {

    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String getOrderId() { return orderId; }
        public String getCustomerName() { return customerName; }
        public double getTotalPrice() { return totalPrice; }

        public void setOrderId(String orderId) { this.orderId = orderId; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

        @Override
        public String toString() {
            return "OrderID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
        }
    }

    public static class SortUtil {
        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
        }

        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);
                quickSort(orders, low, pi - 1);
                quickSort(orders, pi + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() <= pivot) {
                    i++;
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;
            return i + 1;
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("O003", "Alice", 250.00),
                new Order("O001", "Bob", 150.00),
                new Order("O002", "Charlie", 200.00)
        };

        System.out.println("Original Array:");
        for (Order order : orders) {
            System.out.println(order);
        }

        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        SortUtil.bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Array:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        SortUtil.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sorted Array:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
