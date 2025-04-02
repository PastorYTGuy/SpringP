package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Vehicle {
    private String id;
    private String category;
    private String brand;
    private String model;
    private int year;
    private String plate;
    private boolean rented;
}

