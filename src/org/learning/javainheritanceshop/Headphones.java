package org.learning.javainheritanceshop;

import java.math.BigDecimal;

public class Headphones extends Prodotto{
    private String color;
    private boolean wireless;
    private boolean wired;

    public Headphones(String name, String brand, BigDecimal price, BigDecimal vat, String color, boolean wireless,
                      boolean wired) {
        super(name, brand, price, vat);
        this.color = color;
        this.wireless = wireless;
        this.wired = wired;
    }
}
