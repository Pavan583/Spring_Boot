package com.pavan.exception;

import java.io.Serial;

public class OwnerNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
