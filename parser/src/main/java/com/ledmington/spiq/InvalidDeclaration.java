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

public final class InvalidDeclaration extends SpiqParserException {

    @Serial
    private static final long serialVersionUID= 7847187428618395995L;

    public InvalidDeclaration(final String id, final SpiqType type, final NumberLiteral value) {
        super(String.format(
                "Invalid declaration of variable '%s' with type '%s'%s.",
                id, type, (value == null ? "" : " and value " + value)));
    }
}
