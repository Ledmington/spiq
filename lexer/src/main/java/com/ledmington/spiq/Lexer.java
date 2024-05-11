/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.File;
import java.util.Iterator;
import java.util.Objects;

public final class Lexer implements Iterator<SpiqToken> {
    public Lexer(final File file) {
        Objects.requireNonNull(file);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public SpiqToken next() {
        return null;
    }
}
