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

public final class UnexpectedTokenException extends SpiqParserException {

    @Serial
    private static final long serialVersionUID = -8022257077124614436L;

    public UnexpectedTokenException(final SpiqToken token) {
        super(String.format("Unexpected token '%s' was found.", token));
    }

    public UnexpectedTokenException(final SpiqToken actual, final SpiqToken expected) {
        super(String.format("Expected token '%s' but '%s' was found.", expected, actual));
    }
}
