package Grow.BasicOfOOP.FlowerShop.Builder;

import Grow.BasicOfOOP.FlowerShop.Action.ByerAction;
import Grow.BasicOfOOP.FlowerShop.Objects.Wrapping;

import java.util.ArrayList;

public class FlowerGiftBuilder extends GiftBuilder{
    @Override
    void buildName() {
        String name = ByerAction.verifyEnterName();
        gift.setName(name);
    }

    @Override
    void buildPrice() {
        System.out.println("Select gifts for pricing");
        double price = ByerAction.verifyEnterPrice();
        gift.setPrice(price);
    }

    @Override
    void buildWrapping() {
        Wrapping wrapping = ByerAction.selectionWrapping();
        gift.setWrapping(wrapping);
    }

    @Override
    void buildBouquet() {
        gift.setBouquets(new ArrayList<>());
    }
}
