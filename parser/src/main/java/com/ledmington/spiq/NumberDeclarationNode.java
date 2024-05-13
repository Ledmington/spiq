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
