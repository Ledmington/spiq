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

public final class SpiqInvalidLiteralException extends SpiqLexerException {

    @Serial
    private static final long serialVersionUID = -1131305635605369494L;

    public SpiqInvalidLiteralException(final String invalidLiteral) {
        super(String.format("Invalid literal '%s'.", invalidLiteral));
    }
}
