/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.vm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.ledmington.spiq.interpreter.vm.SVM;
import com.ledmington.spiq.interpreter.vm.SpiqVM;
import com.ledmington.spiq.interpreter.vm.Variable;
import com.ledmington.spiq.interpreter.vm.VariableType;
import com.ledmington.spiq.interpreter.vm.exceptions.DoubleDeclaration;

public final class TestVariableDeclaration {

    private SpiqVM vm;

    @BeforeEach
    public void setup() {
        vm = new SVM();
    }

    @Test
    public void initiallyNoVariables() {
        assertEquals(0, vm.getAllVariables().size());
    }

    @Test
    public void nullsAreNotAllowed() {
        assertThrows(NullPointerException.class, () -> vm.newVariable(null, VariableType.INTEGER));
        assertThrows(NullPointerException.class, () -> vm.newVariable("A", null));
        assertThrows(NullPointerException.class, () -> vm.newVariable(null, null));
        assertThrows(IllegalArgumentException.class, () -> vm.newVariable("", VariableType.INTEGER));
    }

    @ParameterizedTest
    @EnumSource(VariableType.class)
    public void allAvailableTypes(final VariableType type) {
        vm.newVariable("A", type);
        assertEquals(1, vm.getAllVariables().size());
        assertEquals(new Variable("A", type), vm.getAllVariables().iterator().next());
    }

    @Test
    public void noDuplicateVariableNames() {
        vm.newVariable("A", VariableType.INTEGER);
        assertThrows(DoubleDeclaration.class, () -> vm.newVariable("A", VariableType.NUMBER));
    }
}
