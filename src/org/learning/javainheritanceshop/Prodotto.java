package org.learning.javainheritanceshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
    // ATTRIBUTI
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;

    // COSTRUTTORI

    public Prodotto(String name, String brand, BigDecimal price, BigDecimal vat) {
        this.code = generateCode();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
    }


    // GETTER E SETTER
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getVat() {
        return vat;
    }
    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getFullPrice() {
        // price + price * vat
        return price.add(price.multiply(vat)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getFullName() {
        return String.format("%08d - %s", code, name);
    }

    public String getAllProductInformation(){
        return String.format("Code: %08d\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nFull Price: %s\nFull Name: %s",
                code, name, brand, getPrice(), vat, getFullPrice(), getFullName());
    }

    // METODI
    private int generateCode(){
        Random random = new Random();
        return random.nextInt(100000000);
    }
}
