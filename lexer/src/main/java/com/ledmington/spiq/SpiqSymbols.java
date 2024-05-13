/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

public enum SpiqSymbols implements SpiqToken {
    NEWLINE('\n'),
    DOT('.');

    private final char repr;

    SpiqSymbols(final char repr) {
        this.repr = repr;
    }

    public String repr() {
        return "" + repr;
    }
}
