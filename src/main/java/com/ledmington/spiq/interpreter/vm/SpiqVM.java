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

/**
 * Spiq Virtual Machine that actually executes the interpreted spiq code.
 */
public interface SpiqVM {

    Collection<Variable> getAllVariables();

    /**
     * Creates a new variable with the given type.
     */
    void newVariable(final String varName, final VariableType type);
}
