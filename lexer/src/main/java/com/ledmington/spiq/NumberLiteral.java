/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.math.BigDecimal;
import java.util.Objects;

public final class NumberLiteral implements SpiqToken {

    private final BigDecimal value;

    private NumberLiteral(final BigDecimal value) {
        this.value = Objects.requireNonNull(value);
    }

    public NumberLiteral(final String value) {
        this.value = new BigDecimal(Objects.requireNonNull(value)).stripTrailingZeros();
    }

    public NumberLiteral(final long value) {
        this(BigDecimal.valueOf(value).stripTrailingZeros());
    }

    public NumberLiteral(final double value) {
        this(BigDecimal.valueOf(value).stripTrailingZeros());
    }

    public boolean isIntegral() {
        return value.signum() == 0
                || value.scale() <= 0
                || value.stripTrailingZeros().scale() <= 0;
    }

    @Override
    public String toString() {
        return "NumberLiteral(" + value + ")";
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + value.hashCode();
        return h;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!this.getClass().equals(other.getClass())) {
            return false;
        }
        // here we use compareTo instead of equals because it doesn't consider scale and significant digits
        return this.value.compareTo(((NumberLiteral) other).value) == 0;
    }
}
