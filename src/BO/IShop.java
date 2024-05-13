

package BO;


import java.util.List;

public interface IShop {
    List<Product> getProductList();
    String enlistProduct(Product aProduct);
    String addSale(Sale aSale);
    String addPurchase(Purchase aPurchase);
    String addDamage(Damage aDamage);
    void executeCommand(Command command);
}
