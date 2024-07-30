public class FinancialForecasting {

    public double calculateFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
    }

    public double calculateFutureValueIterative(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double initialValue = 2000;
        double growthRate = 0.08;
        int periods = 10;

        double futureValueRecursive = forecasting.calculateFutureValue(initialValue, growthRate, periods);
        double futureValueIterative = forecasting.calculateFutureValueIterative(initialValue, growthRate, periods);

        System.out.println("Future Value (Recursive): " + String.format("%.2f", futureValueRecursive));
        System.out.println("Future Value (Iterative): " + String.format("%.2f", futureValueIterative));
    }
}
