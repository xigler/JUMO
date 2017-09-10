package za.co.jumo.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable{

    private String msisdn;
    private String network;
    private LocalDate localDate;
    private String product;
    private double amount;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "msisdn=" + msisdn +
                ", network='" + network + '\'' +
                ", localDate=" + localDate +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }
}
