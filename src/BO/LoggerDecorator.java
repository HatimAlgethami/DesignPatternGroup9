package BO;

import java.util.List;

public class LoggerDecorator implements IShop {
    private IShop shop;
    private ILogger logger;

    public LoggerDecorator(IShop shop, ILogger logger) {
        this.shop = shop;
        this.logger = logger;
    }

    @Override
    public List<Product> getProductList() {
        return shop.getProductList();
    }

    @Override
    public String enlistProduct(Product aProduct) {
        logger.log("Enlisting product: " + aProduct.getName());
        System.out.println("[LOG] ");
        return shop.enlistProduct(aProduct);
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

}
