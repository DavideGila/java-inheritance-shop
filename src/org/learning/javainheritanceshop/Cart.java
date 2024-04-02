package org.learning.javainheritanceshop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Prodotto[] cart = new Prodotto[0];

        boolean exit = false;
        while (!exit) {
            System.out.println("Select the type of product to be added:");
            System.out.println("1. Smartphone");
            System.out.println("2. TV");
            System.out.println("3. Headphones");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    cart = addToCart(cart, createSmartphone(scan));
                    break;
                case 2:
                    cart = addToCart(cart, createTV(scan));
                    break;
                case 3:
                    cart = addToCart(cart, createHeadphones(scan));
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nCart Summary:");
        BigDecimal total = BigDecimal.ZERO;
        for (Prodotto prodotto : cart) {
            System.out.println(prodotto.getAllProductInformation());
            total = total.add(prodotto.getFullPrice());
        }
        System.out.println("Total: " + total);
        scan.close();
    }

    public static Prodotto[] addToCart(Prodotto[] cart, Prodotto newProduct) {
        Prodotto[] newCart = new Prodotto[cart.length + 1];
        System.arraycopy(cart, 0, newCart, 0, cart.length);
        newCart[cart.length] = newProduct;
        return newCart;
    }

    public static Prodotto acquireCommonProductData(Scanner scan) {
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Brand: ");
        String brand = scan.nextLine();
        System.out.print("Price: ");
        BigDecimal price = new BigDecimal(scan.nextLine());
        System.out.print("VAT: ");
        BigDecimal vat = new BigDecimal(scan.nextLine());

        return new Prodotto(name, brand, price, vat);
    }

    public static Smartphone createSmartphone(Scanner scan) {
        Prodotto commonData = acquireCommonProductData(scan);
        System.out.print("IMEI: ");
        String imei = scan.nextLine();
        System.out.print("Memory size: ");
        int memorySize = Integer.parseInt(scan.nextLine());

        return new Smartphone(commonData.getName(), commonData.getBrand(), commonData.getPrice(), commonData.getVat(),
                imei, memorySize);
    }

    public static TV createTV(Scanner scan) {
        Prodotto commonData = acquireCommonProductData(scan);
        System.out.print("Size: ");
        int size = Integer.parseInt(scan.nextLine());
        System.out.print("Is it smart? (Y/N): ");
        boolean smart = Boolean.parseBoolean(scan.nextLine());

        return new TV(commonData.getName(), commonData.getBrand(), commonData.getPrice(), commonData.getVat(), size,
                smart);
    }

    public static Headphones createHeadphones(Scanner scan) {
        Prodotto commonData = acquireCommonProductData(scan);
        System.out.print("Color: ");
        String color = scan.nextLine();
        System.out.print("Are they wireless? (Y/N): ");
        boolean wireless = Boolean.parseBoolean(scan.nextLine());
        System.out.print("Are they wired? (Y/N): ");
        boolean wired = Boolean.parseBoolean(scan.nextLine());

        return new Headphones(commonData.getName(), commonData.getBrand(), commonData.getPrice(), commonData.getVat(),
                color, wireless, wired);
    }

}
