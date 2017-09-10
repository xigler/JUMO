package za.co.jumo.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Aggregate implements Serializable{


    private String network;
    private LocalDate localDate;
    private String product;
    private int counter;
    private double totalAmount;


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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

    @Override
    public String toString() {
        return "Aggregate{" +
                "network='" + network + '\'' +
                ", localDate=" + localDate +
                ", product='" + product + '\'' +
                ", counter=" + counter +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
