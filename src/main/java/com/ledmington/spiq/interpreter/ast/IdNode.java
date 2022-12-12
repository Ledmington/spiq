/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.ast;

import gen.spiqBaseVisitor;

public class IdNode extends Node {

    private final String name;

    public IdNode(final String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
        return null;
    }
}
