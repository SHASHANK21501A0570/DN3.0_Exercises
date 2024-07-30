public class ProxyPatternExample {

    public interface Image {
        void display();
    }

    public static class RealImage implements Image {
        private String imageUrl;

        public RealImage(String imageUrl) {
            this.imageUrl = imageUrl;
            loadImageFromServer();
        }

        private void loadImageFromServer() {
            System.out.println("Fetching image from server: " + imageUrl);
            try {
                Thread.sleep(1500); // Simulate delay in loading
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void display() {
            System.out.println("Showing image from " + imageUrl);
        }
    }

    public static class ProxyImage implements Image {
        private String imageUrl;
        private RealImage realImage;

        public ProxyImage(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(imageUrl);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("http://example.com/photo1.png");
        Image image2 = new ProxyImage("http://example.com/photo2.png");

        System.out.println("Requesting image1:");
        image1.display(); // Fetches from server and displays
        System.out.println("Requesting image1 again:");
        image1.display(); // Displays from cache

        System.out.println("Requesting image2:");
        image2.display(); // Fetches from server and displays
        System.out.println("Requesting image2 again:");
        image2.display(); // Displays from cache
    }
}
