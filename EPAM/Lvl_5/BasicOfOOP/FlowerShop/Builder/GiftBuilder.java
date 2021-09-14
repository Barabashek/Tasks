package Grow.BasicOfOOP.FlowerShop.Builder;

import Grow.BasicOfOOP.FlowerShop.Objects.Gift;

public abstract class GiftBuilder {
    Gift gift;

    public void createGift(){
        gift = new Gift();
    }
    abstract void buildName();
    abstract void buildPrice();
    abstract void buildWrapping();
    abstract void buildBouquet();

    public Gift getGift() {
        return gift;
    }
}
