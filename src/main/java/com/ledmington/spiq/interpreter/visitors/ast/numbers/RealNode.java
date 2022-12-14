/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast.numbers;

import java.math.BigDecimal;

import com.ledmington.spiq.interpreter.visitors.BaseASTVisitor;

public class RealNode extends NumberNode {

    private final BigDecimal value;

    public RealNode(final BigDecimal value) {
        super();
        this.value = value;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        // TODO Auto-generated method stub
        return null;
    }
}
