package Grow.BasicOfOOP.FlowerShop.Builder;

import Grow.BasicOfOOP.FlowerShop.Objects.Gift;

public class GiftDirector {
    GiftBuilder giftBuilder;

    public void setGiftBuilder(GiftBuilder giftBuilder) {
        this.giftBuilder = giftBuilder;
    }
    public Gift buildGift(){
        giftBuilder.createGift();
        giftBuilder.buildName();
        giftBuilder.buildPrice();
        giftBuilder.buildWrapping();
        giftBuilder.buildBouquet();
        return giftBuilder.getGift();
    }

    public GiftBuilder getGiftBuilder() {
        return giftBuilder;
    }
}
