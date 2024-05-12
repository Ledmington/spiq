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

public final class VariableDeclarationNode implements SpiqNode {

    private final String id;
    private final SpiqType type;
    private final NumberLiteral value;

    public VariableDeclarationNode(final String id, final SpiqType type, final NumberLiteral value) {
        this.id = Objects.requireNonNull(id);
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty or blank.");
        }
        this.type = Objects.requireNonNull(type);
        this.value = value;
    }

    public VariableDeclarationNode(final String id, final SpiqType type) {
        this(id, type, null);
    }

    @Override
    public String toString() {
        return "VariableDeclarationNode(id=" + id + ";type=" + type + (value == null ? "" : ";value=" + value) + ")";
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
        final VariableDeclarationNode vdn = (VariableDeclarationNode) other;
        return this.id.equals(vdn.id) && this.type.equals(vdn.type) && Objects.equals(this.value, vdn.value);
    }
}
