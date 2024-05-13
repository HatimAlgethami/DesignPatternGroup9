package BO;

import java.util.ArrayList;
import java.util.List;

public class LoggerDecorator implements IShop, Subject {
    private IShop shop;
    private ILogger logger;
    private List<Observer> observers;

    public LoggerDecorator(IShop shop, ILogger logger) {
        this.shop = shop;
        this.logger = logger;
        this.observers = new ArrayList<>();
    }

    @Override
    public List<Product> getProductList() {
        return shop.getProductList();
    }

    /*
    @Override
    public String enlistProduct(Product aProduct) {
        logger.log("Enlisting product: " + aProduct.getName());
        System.out.println("[LOG] ");
        return shop.enlistProduct(aProduct);
    }
*/
    @Override
    public String enlistProduct(Product aProduct) {
        Command command = new EnlistProductCommand(shop, aProduct);
        executeCommand(command);
        logger.log("Enlisting product: " + aProduct.getName());
        return "Product enlisted.";
    }
    
    @Override
    public String addSale(Sale aSale) {
        logger.log("Adding sale: " + aSale.toString());
        return shop.addSale(aSale);
    }

    @Override
    public String addPurchase(Purchase aPurchase) {
        logger.log("Adding purchase: " + aPurchase.toString());
        return shop.addPurchase(aPurchase);
    }

    @Override
    public String addDamage(Damage aDamage) {
        logger.log("Adding damage: " + aDamage.toString());
        return shop.addDamage(aDamage);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }

}
