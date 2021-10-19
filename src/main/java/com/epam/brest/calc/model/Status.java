package com.epam.brest.calc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Status {

    List<String> messages = new ArrayList<>(Arrays.asList("Enter please weight: ", "Enter please length: "));

    List<BigDecimal> userData = new ArrayList<>();

    Status handle();

    StatusType getType();
}
