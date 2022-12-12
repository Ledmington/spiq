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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ledmington.spiq.interpreter.ExecutionContext;
import com.ledmington.spiq.interpreter.vm.exceptions.DoubleDeclaration;

public final class SVM implements SpiqVM {

    private final List<Variable> allVariables = new LinkedList<>();
    private final Map<String, Variable> allVariablesByName = new HashMap<>();

    @Override
    public ExecutionContext getExecutionContext() {
        return new ExecutionContext(allVariables);
    }

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
        if (allVariablesByName.containsKey(varName)) {
            throw new DoubleDeclaration(varName, allVariablesByName.get(varName).type(), type);
        }
        final Variable v = new Variable(varName, type);
        allVariables.add(v);
        allVariablesByName.put(v.name(), v);
    }
}
