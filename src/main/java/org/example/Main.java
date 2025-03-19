package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("repozytorium.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write("car1;Toyota;Corolla;2015;30000;false");
        writer.newLine();
        writer.write("car2;Ford;Focus;2018;35000;true");
        writer.newLine();
        writer.write("motor1;Sport;Yamaha;R1;2020;50000;false");
        writer.newLine();
        writer.write("motor2;Cruiser;Harley-Davidson;Iron 883;2019;45000;true");
        writer.newLine();
        writer.write("car3;BMW;X5;2021;70000;false");
        writer.close();



        VehicleShop sklepik = new VehicleShop("repozytorium.txt");
        System.out.println("Wynajem pojazdów:");
        if (sklepik.rentVehicle("car1")) {
            System.out.println("Wynajęto: car1");
        } else {
            System.out.println("Nie udało się wynająć: car1");
        }

        if (sklepik.rentVehicle("motor1")) {
            System.out.println("Wynajęto: motor1");
        } else {
            System.out.println("Nie udało się wynająć: motor1");
        }

        // Zwrócenie pojazdu
        System.out.println("Zwrot pojazdów:");
        if (sklepik.returnVehicle("motor2")) {
            System.out.println("Zwrócono: motor2");
        } else {
            System.out.println("Nie udało się zwrócić: motor2");
        }

        System.out.println("getter pojazdu motor:");
        Motorcycle motor = (Motorcycle) sklepik.getVehicle("motor1");
        System.out.println(motor.category + " " + motor.brand + " " + motor.model);

        String sha256hex = DigestUtils.sha256Hex("Lingan guli guli guli wata");
        System.out.println(sha256hex);

    }
}