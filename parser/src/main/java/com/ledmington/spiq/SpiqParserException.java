/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.Serial;

public class SpiqParserException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4708358642763396700L;

    public SpiqParserException() {
        super("An unknown parsing error occurred.");
    }

    public SpiqParserException(final String message) {
        super(message);
    }
}
