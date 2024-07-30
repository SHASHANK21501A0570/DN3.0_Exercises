import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    public interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    public static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private double stockPrice;

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockPrice);
            }
        }

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }
    }

    public interface Observer {
        void update(double stockPrice);
    }

    public static class MobileApp implements Observer {
        private String appName;

        public MobileApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(double stockPrice) {
            System.out.println(appName + " received stock update: " + stockPrice);
        }
    }

    public static class WebApp implements Observer {
        private String appName;

        public WebApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(double stockPrice) {
            System.out.println(appName + " received stock update: " + stockPrice);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp1 = new MobileApp("MobileApp A");
        Observer mobileApp2 = new MobileApp("MobileApp B");
        Observer webApp = new WebApp("WebApp X");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp);

        System.out.println("Setting stock price to 120.0");
        stockMarket.setStockPrice(120.0);

        System.out.println("Removing MobileApp A");
        stockMarket.deregisterObserver(mobileApp1);

        System.out.println("Setting stock price to 150.0");
        stockMarket.setStockPrice(150.0);
    }
}
