package org.example;

import java.util.Objects;

public class Motorcycle extends Vehicle{
    protected final String category;

    public Motorcycle(String category,String brand, String model, int year, int price, boolean rented) {
        super(brand, model, year, price, rented, "motor");
        this.category = category;
    }

    public Motorcycle(String category,String brand, String model, int year, int price, boolean rented, String id) {
        super(brand, model, year, price, rented);
        this.category = category;
        this.id = id;
    }

    @Override
    String toCSV() {
        return String.format("%s;%s;%s;%s;%d;%d;%s", this.id,this.category, this.brand, this.model, this.year, this.price, this.rented);
    }

    public String get_category(){
        return this.category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle pojazd = (Motorcycle) o;
        return year == pojazd.year && Objects.equals(brand, pojazd.brand) && Objects.equals(model, pojazd.model) && price == pojazd.price && Objects.equals(category, pojazd.category); //moze jeszcze dodac tu id lub dodatkowe pole tablica rejestracyjna
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, brand, model, year, price); //moze id lub rejeestracja (bo są unikalne)
    }
}
