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

public final class SpiqID implements SpiqToken {

    private final String id;

    public SpiqID(final String id) {
        this.id = Objects.requireNonNull(id);
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty or blank.");
        }
    }

    public String id() {
        return id;
    }

    @Override
    public String toString() {
        return "SpiqID(" + id + ")";
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + id.hashCode();
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
        return this.id.equals(((SpiqID) other).id);
    }
}
