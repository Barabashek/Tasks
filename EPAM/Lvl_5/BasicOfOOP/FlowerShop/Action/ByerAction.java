package Grow.BasicOfOOP.FlowerShop.Action;

import Grow.BasicOfOOP.FlowerShop.Builder.FlowerGiftBuilder;
import Grow.BasicOfOOP.FlowerShop.Builder.GiftDirector;
import Grow.BasicOfOOP.FlowerShop.Objects.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ByerAction {
    private static Scanner scanner = new Scanner(System.in);
    private static Byer byer;

    public void run() {
        System.out.println("Say your name please!");
        byer.setName(verifyEnterName());

        GiftDirector giftDirector = new GiftDirector();
        giftDirector.setGiftBuilder(new FlowerGiftBuilder());
        System.out.println(byer.getName() + ", what event do you need a bouquet?");
        byer.setGift(giftDirector.buildGift());
        byer.getGift().setBouquets(fillBouquet());

        System.out.println("Your bouquet for " + byer.getGift().getName() + "is ready");
        printGift(byer.getGift());

    }
    public static String verifyEnterName() {
        Pattern pattern = Pattern.compile("[a-zA-Z]{2,30}");
        scanner.useDelimiter("[\r\n]");
        while (!scanner.hasNext(pattern)){
            scanner.nextLine();
            System.out.println("Error enter name. Name most be from 2 to 30 symbols long.");
        }
        return scanner.nextLine();
    }
    public static double verifyEnterPrice(){
        Pattern pattern = Pattern.compile("[\\d ]{1,5}");
        scanner.useDelimiter("[\r\n]");
        while (true){
            while (!scanner.hasNext(pattern)){
                scanner.nextLine();
                System.out.println("Price of gift can be from 5 to 1000");
            }
            double enter = scanner.nextDouble();
            if (enter >= 5 && enter <= 1000){
                return enter;
            } else {
                System.out.println("Price of gift can be from 5 to 1000");
            }
        }
    }
    public static Wrapping selectionWrapping(){
        System.out.println(byer.getName() + ", choose some type of wrap: ");
        System.out.printf("1. Flower Box (price: %.2f). \n2. Paper (price: %.2f).\n" +
                "3. Grid (price: %.2f).\n4. Organza (price: %.2f)", WrappingType.FLOWERBOX.getPrice(),
                WrappingType.PAPER.getPrice(), WrappingType.GRID.getPrice(), WrappingType.ORGANZA.getPrice());
        System.out.println("Choose the number of the desired package");
        int number = verifyEnterNumber();
        Wrapping wrapping = null;
        switch (number){
            case 1: wrapping = new Wrapping(WrappingType.FLOWERBOX);
                    break;
            case 2: wrapping = new Wrapping(WrappingType.PAPER);
                    break;
            case 3: wrapping = new Wrapping(WrappingType.GRID);
                    break;
            case 4: wrapping = new Wrapping(WrappingType.ORGANZA);
        }
        return wrapping;
    }
    public static int verifyEnterNumber(){
        Pattern pattern = Pattern.compile("[1-4]");
        scanner.useDelimiter("[\r\n]");
        while (!scanner.hasNext(pattern)){
            scanner.nextLine();
            System.out.println("Incorrect enter. Input number from 1 to 4.");
        }
        return scanner.nextInt();
    }
    public static List<Bouquet> fillBouquet(){
        List<Bouquet> bouquets = readFromFile();
        List<Bouquet> flowersGift = new ArrayList<>();
        int giftQuantity = 0;
        double minPrice = 16.50;
        Random random = new Random();

        double byerBalance = byer.getGift().getPrice() - byer.getGift().getWrapping().getPrice();
        while (byerBalance > 0){
            Bouquet flower = bouquets.get(random.nextInt(bouquets.size()));
            double flowerCost = flower.getPrice();
            int flowerQuantity = flower.getQuantity();

            if (byerBalance - flowerCost > 0){
                flowersGift.add(flower);
                giftQuantity += flowerQuantity;
                byerBalance -= flowerCost;
            } else if (minPrice > byerBalance){break;}
        }
        byer.getGift().setPrice(byer.getGift().getPrice() - byerBalance);
        byer.getGift().setQuantity(giftQuantity);
        return flowersGift;
    }
    public static List<Bouquet> readFromFile(){
        List<Bouquet> flowers = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("F:\\Project\\src\\Grow\\BasicOfOOP\\FlowerShop\\Information\\flower.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            while (reader.readLine() != null){
                String [] bouquetList = reader.readLine().split(" - ");
                try {
                    String bouquetName = bouquetList[0];
                    int quantity = Integer.parseInt(bouquetList[1]);
                    double price = Double.parseDouble(bouquetList[2]);
                    FlowerVariety flowerVariety;
                    switch (bouquetList[3]){
                        case "Wedding": flowerVariety = FlowerVariety.WEDDING;
                            break;
                        case "New Year": flowerVariety = FlowerVariety.NEWYEAR;
                            break;
                        case "Anniversary": flowerVariety = FlowerVariety.ANNIVERSARY;
                            break;
                        case "Сorporate": flowerVariety = FlowerVariety.CORPORATE;
                        default: flowerVariety = FlowerVariety.WEDDING;
                    }
                    flowers.add(new Flower(bouquetName, quantity, price, flowerVariety));
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            System.out.println("No such file");
        }
        return flowers;
    }
    public void printGift(Gift gift){
        System.out.println(gift);
    }
}
