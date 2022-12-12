/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.vm;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class SVM implements SpiqVM {

    private final List<Variable> allVariables = new LinkedList<>();

    @Override
    public Collection<Variable> getAllVariables() {
        return allVariables;
    }

    @Override
    public void newVariable(final String varName, final VariableType type) {
        Objects.requireNonNull(varName);
        Objects.requireNonNull(type);
        if (varName.equals("")) {
            throw new IllegalArgumentException("Variable name cannot be empty.");
        }
        allVariables.add(new Variable(varName, type));
    }
}
