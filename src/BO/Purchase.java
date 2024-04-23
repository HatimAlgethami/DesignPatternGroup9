package BO;



public class Purchase extends OperationOnProduct implements Cloneable {

    private String vendorName;
    private double totalAmount;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public Purchase clone() throws CloneNotSupportedException {
        return (Purchase) super.clone();
    }
}
