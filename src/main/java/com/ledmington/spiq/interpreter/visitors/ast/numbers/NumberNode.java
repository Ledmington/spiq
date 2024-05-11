/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast.numbers;

import com.ledmington.spiq.interpreter.visitors.BaseASTVisitor;
import com.ledmington.spiq.interpreter.visitors.ast.Node;

public abstract class NumberNode extends Node {

    public NumberNode() {
        super();
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
