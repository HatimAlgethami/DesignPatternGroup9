package BO;

public class Sale extends OperationOnProduct implements Cloneable {

    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public Sale clone() throws CloneNotSupportedException {
        return (Sale) super.clone();
    }
}