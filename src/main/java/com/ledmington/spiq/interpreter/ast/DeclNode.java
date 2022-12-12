/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.ast;

import com.ledmington.spiq.interpreter.ast.numbers.NumberNode;

import gen.spiqBaseVisitor;

public class DeclNode extends Node {

    private final IdNode id;
    private final NumberNode number;

    public DeclNode(final IdNode id, final NumberNode number) {
        super();
        this.id = id;
        this.number = number;
    }

    @Override
    public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
        return null;
    }
}
