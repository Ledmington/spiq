/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.compiler.ast.numbers;

import com.ibm.icu.math.BigDecimal;

public class RealNode extends NumberNode {
    private final BigDecimal value;

    public RealNode(final BigDecimal value) {
        super();
        this.value = value;
    }
}
