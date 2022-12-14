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
import com.ledmington.spiq.interpreter.visitors.ast.numbers.NumberNode;

public class DeclNode extends Node {

    private final IdNode id;
    private final NumberNode number;

    public DeclNode(final IdNode id, final NumberNode number) {
        super();
        this.id = id;
        this.number = number;
    }

    public IdNode id() {
        return id;
    }

    public NumberNode number() {
        return number;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
