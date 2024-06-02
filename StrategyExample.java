// Strategy Interface
interface DiscountStrategy {
    double applyDiscount(double price);
}

// Concrete Strategy A
class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}

// Concrete Strategy B
class SeasonalDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

// Concrete Strategy C
class ClearanceDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.5;
    }
}

// Context
class PriceCalculator {
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}

// Main
public class StrategyExample {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        
        calculator.setStrategy(new NoDiscountStrategy());
        System.out.println("Price with no discount: " + calculator.calculatePrice(100));

        calculator.setStrategy(new SeasonalDiscountStrategy());
        System.out.println("Price with seasonal discount: " + calculator.calculatePrice(100));

        calculator.setStrategy(new ClearanceDiscountStrategy());
        System.out.println("Price with clearance discount: " + calculator.calculatePrice(100));
    }
}
