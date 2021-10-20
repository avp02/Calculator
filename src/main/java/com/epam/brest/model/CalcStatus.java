package com.epam.brest.model;

import com.epam.brest.calc.CalcImpl;
import com.epam.brest.selector.PriceSelector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.*;

public class CalcStatus extends AbstractStatus{

    public CalcStatus(Scanner scanner, Map<Integer, BigDecimal> pricePerKgMap, Map<Integer, BigDecimal> pricePerKmMap) {
        this.scanner = scanner;
        this.pricePerKgMap = pricePerKgMap;
        this.pricePerKmMap = pricePerKmMap;
    }

    @Override
    public Status handle() {
        try {
            BigDecimal pricePerKg = new PriceSelector().selectPriceValue(pricePerKgMap, userData.get(0));
            BigDecimal pricePerKm = new PriceSelector().selectPriceValue(pricePerKmMap, userData.get(1));
            BigDecimal result = new CalcImpl().handle(pricePerKg, userData.get(0), pricePerKm, userData.get(1));
            System.out.println("Result: " + result);
        } finally {
            userData.clear();
        }
        return new ReadDataStatus(scanner, pricePerKgMap, pricePerKmMap);
    }

    @Override
    public StatusType getType() {
        return CALC;
    }
}
