/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.ast.numbers;

import com.ledmington.spiq.interpreter.ast.Node;

import gen.spiqBaseVisitor;

public abstract class NumberNode extends Node {

    public NumberNode() {
        super();
    }

    @Override
    public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
        return null;
    }
}
