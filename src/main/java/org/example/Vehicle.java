package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected int price;
    protected boolean rented;
    protected String id;
    private static final AtomicInteger carCounter = new AtomicInteger(0);
    private static final AtomicInteger motorCounter = new AtomicInteger(0);

    public Vehicle(String brand, String model, int year, int price, boolean rented, String id_prefix){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;

        if (id_prefix.equals("car")) {
            this.id = id_prefix + carCounter.incrementAndGet();
        } else if (id_prefix.equals("motor")) {
            this.id = id_prefix + motorCounter.incrementAndGet();
        }
    }

    public Vehicle(String brand, String model, int year, int price, boolean rented){//opcja dla klona bez id
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;
        this.id = null;
    }

    public String getId() {
        return id;
    }

    public void rent() {
        this.rented = true;
    }

    public void return_it() {
        this.rented = false;
    }

    public boolean isRented() {
        return rented;
    }

    abstract String toCSV();


}
