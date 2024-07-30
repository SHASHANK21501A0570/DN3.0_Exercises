import java.util.HashMap;
import java.util.Map;

public class InventorySystemExample {

    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName +
                    ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    public static class InventorySystem {
        private Map<String, Product> inventory = new HashMap<>();

        public void addProduct(Product product) {
            inventory.put(product.getProductId(), product);
        }

        public void updateProduct(String productId, Product newProduct) {
            if (inventory.containsKey(productId)) {
                inventory.put(productId, newProduct);
            }
        }

        public void deleteProduct(String productId) {
            inventory.remove(productId);
        }

        public Product getProduct(String productId) {
            return inventory.get(productId);
        }

        public void displayInventory() {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();

        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 25, 499.99);
        Product product3 = new Product("P003", "Headphones", 50, 89.99);

        inventorySystem.addProduct(product1);
        inventorySystem.addProduct(product2);
        inventorySystem.addProduct(product3);

        System.out.println("Initial Inventory:");
        inventorySystem.displayInventory();

        Product updatedProduct = new Product("P002", "Smartphone", 20, 459.99);
        inventorySystem.updateProduct("P002", updatedProduct);

        System.out.println("\nUpdated Inventory:");
        inventorySystem.displayInventory();

        inventorySystem.deleteProduct("P003");

        System.out.println("\nFinal Inventory:");
        inventorySystem.displayInventory();
    }
}
