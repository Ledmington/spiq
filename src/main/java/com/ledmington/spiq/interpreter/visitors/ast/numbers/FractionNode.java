/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast.numbers;

import java.math.BigInteger;

public class FractionNode extends NumberNode {

    private final BigInteger numerator;
    private final BigInteger denominator;

    public FractionNode(final BigInteger numerator, final BigInteger denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
