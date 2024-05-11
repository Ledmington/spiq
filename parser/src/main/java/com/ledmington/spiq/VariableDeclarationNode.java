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

    public VariableDeclarationNode(final String id, final SpiqType type) {
        this.id = Objects.requireNonNull(id);
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty or blank.");
        }
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public String toString() {
        return "VariableDeclarationNode(id=" + id + ";type=" + type + ")";
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + id.hashCode();
        h = 31 * h + type.hashCode();
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
        return this.id.equals(vdn.id) && this.type.equals(vdn.type);
    }
}
