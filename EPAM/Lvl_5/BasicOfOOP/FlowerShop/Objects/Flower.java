package Grow.BasicOfOOP.FlowerShop.Objects;

public class Flower extends Bouquet{
    private FlowerVariety flowerVariety;

    public Flower(String name, int quantity, double price, FlowerVariety flowerVariety) {
        super(name, quantity, price);
        this.flowerVariety = flowerVariety;
    }
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getType().getName());
        builder.append("\"");
        builder.append(getName());
        builder.append('\"');
        builder.append(", quantity=");
        builder.append(getQuantity());
        builder.append(", price=");
        builder.append(getPrice());
        builder.append(" USD.");
        return  builder.toString();
    }
}
