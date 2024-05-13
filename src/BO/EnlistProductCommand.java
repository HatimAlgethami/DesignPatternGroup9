package BO;

import java.util.List;

public class EnlistProductCommand implements Command {
    private IShop shop;
    private Product product;

    public EnlistProductCommand(IShop shop, Product product) {
        this.shop = shop;
        this.product = product;
    }

    @Override
    public void execute() {
        if (validateProduct()) {
            shop.enlistProduct(product);
        } else {
            System.out.println("Product code or name is already enlisted.");
        }
    }
    
    private boolean validateProduct() {
        List<Product> productList = shop.getProductList();
        for (Product existingProduct : productList) {
            if (existingProduct.getCode().equals(product.getCode()) || existingProduct.getName().equals(product.getName())) {
                return false; 
            }
        }
        return true; 
    }
}

