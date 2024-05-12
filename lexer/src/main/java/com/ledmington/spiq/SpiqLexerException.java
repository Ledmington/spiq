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

public class SpiqLexerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 4724667804859234733L;

    public SpiqLexerException() {
        super("An unknown lexical error occurred.");
    }

    public SpiqLexerException(final String message) {
        super(message);
    }
}
