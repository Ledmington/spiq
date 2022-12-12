/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ledmington.spiq.interpreter.SpiqInterperter;
import com.ledmington.spiq.interpreter.vm.VariableType;

public class TestNumberDeclaration {

    private SpiqInterperter interpreter;

    private final Map<String, VariableType> typesByName = new HashMap<>() {
        {
            put("a number", VariableType.NUMBER);
            put("an integer", VariableType.INTEGER);
            put("a fraction", VariableType.RATIONAL);
            put("a rational", VariableType.RATIONAL);
            put("a real", VariableType.REAL);
        }
    };

    @BeforeEach
    public void setup() {
        interpreter = new SpiqInterperter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a number", "an integer", "a fraction", "a rational", "a real"})
    public void withoutValue(String type) {
        assertEquals(0, interpreter.compile("A is " + type + "."));
        assertEquals(
                typesByName.get(type),
                interpreter.getExecutionContext().variables().iterator().next().type());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "12", "0", "+2", "-012", "+036"})
    @Disabled
    public void integerDeclaration(String number) {
        assertEquals(0, interpreter.compile("A is " + number + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"5/7", "0/3", "2/0", "-1/12", "+13/31", "-06/3", "+07/4", "-5/09", "+6/02"})
    @Disabled
    public void fractionDeclaration(String fraction) {
        assertEquals(0, interpreter.compile("A is " + fraction + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2", "-3.6", "+6.5", "-03.1", "+06.2", "-9.02", "+7.03"})
    @Disabled
    public void realDeclarationNormalForm(String real) {
        assertEquals(0, interpreter.compile("A is " + real + "."));
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                "-1e1",
                "+1e1",
                "1e1",
                "-1e-1",
                "+1e-1",
                "1e-1",
                "-1e+1",
                "+1e+1",
                "1e+1",
                "-3.6e-01",
                "+2.09e+050"
            })
    @Disabled
    public void realDeclarationExponentialForm(String real) {
        assertEquals(0, interpreter.compile("A is " + real + "."));
    }
}
