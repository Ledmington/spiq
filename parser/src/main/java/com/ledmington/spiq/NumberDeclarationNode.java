/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.util.Objects;

public final class NumberDeclarationNode extends VariableDeclarationNode {

    private final NumberLiteral value;

    public NumberDeclarationNode(final String id, final SpiqType type, final NumberLiteral value) {
        super(id, type);
        this.value = value;
    }

    public NumberDeclarationNode(final String id, final SpiqType type) {
        this(id, type, null);
    }

    @Override
    public String toString() {
        return "NumberDeclarationNode(id=" + id + ";type=" + type + (value == null ? "" : ";value=" + value) + ")";
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + id.hashCode();
        h = 31 * h + type.hashCode();
        h = 31 * h + (value == null ? 0 : value.hashCode());
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
        final NumberDeclarationNode ndn = (NumberDeclarationNode) other;
        return this.id.equals(ndn.id) && this.type.equals(ndn.type) && Objects.equals(this.value, ndn.value);
    }
}
