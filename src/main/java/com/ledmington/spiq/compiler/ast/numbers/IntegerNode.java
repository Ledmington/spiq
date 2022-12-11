/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.compiler.ast.numbers;

import java.math.BigInteger;

public class IntegerNode extends NumberNode {
    private final BigInteger value;

    public IntegerNode(final BigInteger value) {
        super();
        this.value = value;
    }
}
