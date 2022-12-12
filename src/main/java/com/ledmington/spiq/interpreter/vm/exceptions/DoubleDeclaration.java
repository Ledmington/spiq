/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.vm.exceptions;

import com.ledmington.spiq.interpreter.vm.VariableType;

public final class DoubleDeclaration extends RuntimeException {
    public DoubleDeclaration(final String varName, final VariableType oldType, final VariableType newType) {
        super(String.format(
                "Cannot declare variable %s with type %s because a variable %s with type %s already exists.",
                varName, newType, varName, oldType));
    }
}
