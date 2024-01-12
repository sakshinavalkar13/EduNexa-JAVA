import java.util.ArrayList;
import java.util.List;

// Subject interface
interface ProductObservable {
    void addObserver(CustomerObserver observer);
    void removeObserver(CustomerObserver observer);
    void notifyObservers();
}

// Observer interface
interface CustomerObserver {
    void update(String productName, boolean available);
}

// Product (Subject)
class Product implements ProductObservable {
    private String productName;
    private boolean available;
    private List<CustomerObserver> observers = new ArrayList<>();

    public Product(String productName) {
        this.productName = productName;
        this.available = false;
    }

    @Override
    public void addObserver(CustomerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CustomerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CustomerObserver observer : observers) {
            observer.update(productName, available);
        }
    }

    public void setAvailability(boolean available) {
        this.available = available;
        notifyObservers(); // Notify observers when availability changes
    }
}

// Customer (Observer)
class Customer implements CustomerObserver {
    private String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName, boolean available) {
        System.out.println("Hello " + customerName + ", Product " + productName + " is now " + (available ? "available" : "not available"));
    }
}

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Smartphone");

        Customer customer1 = new Customer("Sakshi");
        Customer customer2 = new Customer("Manoj");

        // Customer registration for product updates
        product.addObserver(customer1);
        product.addObserver(customer2);

        // Product availability changes
        product.setAvailability(true);
        product.setAvailability(false);

        // Bob is no longer interested
        product.removeObserver(customer2);

        // Product availability changes again
        product.setAvailability(true);
    }
}
