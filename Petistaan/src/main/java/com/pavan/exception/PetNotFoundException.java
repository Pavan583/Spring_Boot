package com.pavan.exception;

import java.io.Serial;

public class PetNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public PetNotFoundException(String message) {
        super(message);
    }
}
