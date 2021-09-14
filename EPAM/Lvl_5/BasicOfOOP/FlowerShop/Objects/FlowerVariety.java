package Grow.BasicOfOOP.FlowerShop.Objects;

public enum  FlowerVariety implements Type {
    WEDDING("Wedding", 15),
    NEWYEAR("New Year", 14),
    CORPORATE("Corporate", 30),
    ANNIVERSARY("Anniversary", 20);

    private String name;
    private int price;

    FlowerVariety(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
