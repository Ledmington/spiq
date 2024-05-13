/*
* spiq - Human readable programming language
* Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
