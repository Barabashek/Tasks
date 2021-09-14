package Grow.BasicOfOOP.FlowerShop.Objects;

public class Wrapping {
    private WrappingType wrappingType;
    private double price;

    public Wrapping(WrappingType wrappingType) {
        this.wrappingType = wrappingType;
        price = wrappingType.getPrice();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return wrappingType.getName();
    }
}
