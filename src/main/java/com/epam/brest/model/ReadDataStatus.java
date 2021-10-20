package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.*;

public class ReadDataStatus extends AbstractStatus {

    public static final int NUMBER_OF_USER_DATA = 2;

    public ReadDataStatus(Scanner scanner, Map<Integer, BigDecimal> pricePerKgMap, Map<Integer, BigDecimal> pricePerKmMap) {
        this.scanner = scanner;
        this.pricePerKgMap = pricePerKgMap;
        this.pricePerKmMap = pricePerKmMap;
    }

    @Override
    public Status handle() {

        if (userData.size() < NUMBER_OF_USER_DATA) {
            System.out.println(messages.get(userData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("q")) {
                return new ExitStatus();
            } else if (isCorrectValue(inputValue)) {
                userData.add(new BigDecimal(inputValue));
            }
        } else {
            return new CalcStatus(scanner, pricePerKgMap, pricePerKmMap);
        }
        return this;
    }

    private boolean isCorrectValue(String inputValue) {
        try {
            BigDecimal enteredValue = new BigDecimal(inputValue);
            if (enteredValue.doubleValue() <= 0) {
                System.out.println("Value must be more zero");
            }
            return enteredValue.doubleValue() > 0;
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect value " + inputValue);
        }
        return false;
    }

    @Override
    public StatusType getType() {
        return READ_DATA;
    }
}
