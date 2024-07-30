import java.util.Arrays;

public class ProductSearchExample {

    public static class Product {
        private String productId;
        private String productName;
        private String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    public static class SearchUtil {
        public static Product linearSearch(Product[] products, String searchTerm) {
            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(searchTerm)) {
                    return product;
                }
            }
            return null;
        }

        public static Product binarySearch(Product[] products, String searchTerm) {
            int left = 0;
            int right = products.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cmp = products[mid].getProductName().compareToIgnoreCase(searchTerm);
                if (cmp == 0) {
                    return products[mid];
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }

        public static void sortProductsByName(Product[] products) {
            Arrays.sort(products, (a, b) -> a.getProductName().compareToIgnoreCase(b.getProductName()));
        }
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P003", "Headphones", "Electronics"),
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Smartphone", "Electronics")
        };

        System.out.println("Original Array:");
        for (Product product : products) {
            System.out.println(product);
        }

        Product searchResult = SearchUtil.linearSearch(products, "Smartphone");
        System.out.println("\nLinear Search Result:");
        System.out.println(searchResult != null ? searchResult : "Product not found");

        SearchUtil.sortProductsByName(products);
        System.out.println("\nSorted Array:");
        for (Product product : products) {
            System.out.println(product);
        }

        searchResult = SearchUtil.binarySearch(products, "Laptop");
        System.out.println("\nBinary Search Result:");
        System.out.println(searchResult != null ? searchResult : "Product not found");

        searchResult = SearchUtil.binarySearch(products, "Tablet");
        System.out.println("\nBinary Search Result for 'Tablet':");
        System.out.println(searchResult != null ? searchResult : "Product not found");
    }
}
