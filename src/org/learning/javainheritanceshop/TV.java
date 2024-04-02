package org.learning.javainheritanceshop;

import java.math.BigDecimal;

public class TV extends Prodotto{
    private int size;
    private boolean smart;

    public TV(String name, String brand, BigDecimal price, BigDecimal vat, int size, boolean smart) {
        super(name, brand, price, vat);
        this.size = size;
        this.smart = smart;
    }
}
