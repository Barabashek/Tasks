package Grow.BasicOfOOP.FlowerShop.Objects;

public enum WrappingType implements Type{
    FLOWERBOX("Box Flower", 5.00),
    PAPER("Paper", 2.10),
    GRID("Grid", 0.99),
    ORGANZA("Organza", 3.50);


    private String name;
    private double price;

    WrappingType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
