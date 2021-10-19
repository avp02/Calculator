package com.epam.brest.calc.model;

import static com.epam.brest.calc.model.StatusType.*;

public class ExitStatus implements Status{

    @Override
    public Status handle() {
        return null;
    }

    @Override
    public StatusType getType() {
        return EXIT;
    }
}
