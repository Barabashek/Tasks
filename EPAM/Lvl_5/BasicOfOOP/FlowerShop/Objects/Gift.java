package Grow.BasicOfOOP.FlowerShop.Objects;

import java.util.List;
import java.util.stream.Collectors;

public class Gift {
    private String name;
    private int quantity;
    private double price;
    private Wrapping wrapping;
    private List<Bouquet> bouquets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Wrapping getWrapping() {
        return wrapping;
    }

    public void setWrapping(Wrapping wrapping) {
        this.wrapping = wrapping;
    }

    public List<Bouquet> getBouquets() {
        return bouquets;
    }

    public void setBouquets(List<Bouquet> bouquets) {
        this.bouquets = bouquets;
    }
    public String getBouquetsList(){
        if (bouquets.size() == 0){
            return "List is empty";
        }
        String builder = bouquets.stream().map(bouquet -> bouquet + "\n").collect(Collectors.joining());
        return builder;
    }

    @Override
    public String toString() {
        return "Bouquet " + getName() + " - " +
                "quantity flower - " + getQuantity() +
                ", price - " + String.format("%.2f", getPrice()) +
                " USD, wrapping - " + getWrapping() + getBouquetsList();
    }
}
