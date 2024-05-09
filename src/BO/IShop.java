/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;


import java.util.List;

public interface IShop {
    List<Product> getProductList();
    String enlistProduct(Product aProduct);
    String addSale(Sale aSale);
    String addPurchase(Purchase aPurchase);
    String addDamage(Damage aDamage);
}
