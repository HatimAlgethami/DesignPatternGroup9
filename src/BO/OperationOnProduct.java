package BO;

import com.toedter.calendar.JDateChooser;

public class OperationOnProduct implements Cloneable {

    private Product product;
    private JDateChooser jDateChooser;
    private int transactionQuantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public JDateChooser getOperationDate() {
        return jDateChooser;
    }

    public void setOperationDate(JDateChooser jDateChooser) {
        this.jDateChooser = jDateChooser;
    }

    public int getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(int transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    @Override
    public OperationOnProduct clone() throws CloneNotSupportedException {
        OperationOnProduct cloned = (OperationOnProduct) super.clone();
        
        return cloned;
    }
}