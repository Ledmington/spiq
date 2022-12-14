/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast;

import com.ledmington.spiq.interpreter.visitors.BaseASTVisitor;

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
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
