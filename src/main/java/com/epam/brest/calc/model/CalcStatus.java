package com.epam.brest.calc.model;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.calc.model.StatusType.*;

public class CalcStatus implements Status{

    private final Scanner scanner;

    public CalcStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Status handle() {
        try {
            System.out.println("Result: " + userData.get(0).multiply(BigDecimal.valueOf(1))
                    .add(userData.get(1).multiply(BigDecimal.valueOf(1))));
        } finally {
            userData.clear();
        }
        return new ReadDataStatus(scanner);
    }

    @Override
    public StatusType getType() {
        return CALC;
    }
}
