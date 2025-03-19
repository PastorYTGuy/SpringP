package org.example;

import java.util.Objects;

public class Car extends Vehicle{


    public Car(String brand, String model, int year, int price, boolean rented) {
        super(brand, model, year, price, rented, "car");
    }

    public Car(String brand, String model, int year, int price, boolean rented, String id) {
        super(brand, model, year, price, rented);
        this.id = id;
    }

    @Override
    String toCSV() {
        return String.format("%s;%s;%s;%d;%d;%s",this.id, this.brand, this.model, this.year, this.price, this.rented);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car pojazd = (Car) o;
        return year == pojazd.year && Objects.equals(brand, pojazd.brand) && Objects.equals(model, pojazd.model) && price == pojazd.price; //moze jeszcze dodac tu id lub dodatkowe pole tablica rejestracyjna
    }

    @Override
    public int hashCode() {
        return Objects.hash(id ,brand, model, year, price);//moze dodac id lub tablice rejestracyjną bo są unikatowe
    }



}
