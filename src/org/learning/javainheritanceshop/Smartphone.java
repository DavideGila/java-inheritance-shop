package org.learning.javainheritanceshop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private String imei;
    private int memorySize;
    public Smartphone(String name, String brand, BigDecimal price, BigDecimal vat, String imei, int memorySize) {
        super(name, brand, price, vat);
        this.imei = imei;
        this.memorySize = memorySize;
    }

}
