package BO;

import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;

public class Shop implements IShop,Subject, Cloneable {
    private List<Product> productList;
    private List<Purchase> purchaseList;
    private List<Sale> salesList;
    private List<Damage> damageList;
    private static Shop instance;
    private List<Observer> observers;


    private Shop() {
        productList = new ArrayList<>();
        purchaseList = new ArrayList<>();
        salesList = new ArrayList<>();
        damageList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Shop getInstance() {
        if (instance == null) {
            synchronized (Shop.class) {
                if (instance == null) {
                    instance = new Shop();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String enlistProduct(Product aProduct) {
    productList.add(aProduct);
    return "Product is enlisted.";
    }
/*
    @Override
    public String enlistProduct(Product aProduct) {
        for (Product product1 : productList) {
            if (product1.getCode().equals(aProduct.getCode())) {
                return "This product code is already enlisted.";
            } else if (product1.getName().equals(aProduct.getName())) {
                return "Product name is already enlisted.";
            }
        }

        productList.add(aProduct);
        return "Product is enlisted.";
    }
*/
    @Override
    public String addSale(Sale aSale) {
        for (Product aProduct : productList) {
            if (aProduct.getCode().equals(aSale.getProduct().getCode())) {
                if (aProduct.getTotalQuantity() >= aSale.getTransactionQuantity()) {
                    aProduct.setTotalQuantity(aProduct.getTotalQuantity() - aSale.getTransactionQuantity());
                } else {
                    return "Sorry, you don't have enough quantity to sell.";
                }
            }
        }

        salesList.add(aSale);
        return "Sale has been updated.";
    }

    @Override
    public String addPurchase(Purchase aPurchase) {
        for (Product aProduct : productList) {
            if (aProduct.getCode().equals(aPurchase.getProduct().getCode())) {
                aProduct.setTotalQuantity(aProduct.getTotalQuantity() + aPurchase.getTransactionQuantity());
            }
        }

        purchaseList.add(aPurchase);
        return "Purchase has been updated.";
    }
/* // Before Observer Design Pattern
    @Override
    public String addDamage(Damage aDamage) {
        for (Product aProduct : productList) {
            if (aProduct.getCode().equals(aDamage.getProduct().getCode())) {
                if (aProduct.getTotalQuantity() >= aDamage.getTransactionQuantity()) {
                    aProduct.setTotalQuantity(aProduct.getTotalQuantity() - aDamage.getTransactionQuantity());
                } else {
                    return "Damage quantity can't exceed total quantity.";
                }
            }
        }
        damageList.add(aDamage);
        return "Damage has been updated.";
    }
    */
    // 
    @Override
    public String addDamage(Damage aDamage) {
    boolean damageAdded = false;
    for (Product aProduct : productList) {
        if (aProduct.getCode().equals(aDamage.getProduct().getCode())) {
            if (aProduct.getTotalQuantity() >= aDamage.getTransactionQuantity()) {
                aProduct.setTotalQuantity(aProduct.getTotalQuantity() - aDamage.getTransactionQuantity());
                damageAdded = true;
                break; // Exit the loop since damage is added
            } else {
                return "Damage quantity can't exceed total quantity.";
            }
        }
    }

    if (damageAdded) {
        damageList.add(aDamage);
        notifyObservers("Damage added (Observer): " + aDamage.getCause()); // Notify observers about the added damage
        return "Damage has been updated.";
    } else {
        return "Product not found or damage not added.";
    }
}
  
    
    public List<Sale> getSalesOfADate(JDateChooser jDateChooser) {
        List<Sale> salesOfADate = new ArrayList<Sale>();
        for (Sale aSale : salesList) {
            if (aSale.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aSale.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aSale.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                salesOfADate.add(aSale);
            }
        }

        return salesOfADate;
    }

    public List<Purchase> getPurchaseOfADate(JDateChooser jDateChooser) {
        List<Purchase> purchaseOfADate = new ArrayList<Purchase>();
        for (Purchase aPurchase : purchaseList) {
            if (aPurchase.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aPurchase.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aPurchase.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                purchaseOfADate.add(aPurchase);
            }
        }

        return purchaseOfADate;
    }

    public List<Damage> getDamageOfADate(JDateChooser jDateChooser) {
        List<Damage> damageOfADate = new ArrayList<Damage>();
        for (Damage aDamage : damageList) {
            if (aDamage.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aDamage.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aDamage.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                damageOfADate.add(aDamage);
            }
        }

        return damageOfADate;
    }
    // Phase 1 : Prototype
    @Override
    public Shop clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not supported for singleton objects.");
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
