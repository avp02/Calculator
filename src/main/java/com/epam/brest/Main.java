package com.epam.brest;

import com.epam.brest.calc.model.ReadDataStatus;
import com.epam.brest.calc.model.Status;

import java.util.Scanner;

import static com.epam.brest.calc.model.StatusType.EXIT;

public class Main {

    public static void main(String[] arg) {
        //result = weight*pricePerKg + km*pricePerKm;
        //scanner =
        //prop / json / csv

        try (Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadDataStatus(scanner);
            while (currentStatus.getType() != EXIT) {
                System.out.println("Current system status: " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }
    }
}
