package BO;

public class Damage extends OperationOnProduct implements Cloneable {

    private String cause;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public Damage clone() throws CloneNotSupportedException {
        return (Damage) super.clone();
    }
}