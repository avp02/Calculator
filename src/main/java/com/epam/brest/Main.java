package com.epam.brest;

import com.epam.brest.files.CSVFileReader;
import com.epam.brest.model.ReadDataStatus;
import com.epam.brest.model.Status;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.EXIT;

public class Main {

    public static void main(String[] arg) throws IOException {
        //result = weight*pricePerKg + km*pricePerKm;
        //prop / json / csv
        Map<Integer, BigDecimal> pricePerKgMap = new CSVFileReader().readData("price_weight.csv");
        Map<Integer, BigDecimal> pricePerKmMap = new CSVFileReader().readData("price_distance.csv");

        try (Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadDataStatus(scanner, pricePerKgMap, pricePerKmMap);
            while (currentStatus.getType() != EXIT) {
                System.out.println("Current system status: " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }
    }
}
