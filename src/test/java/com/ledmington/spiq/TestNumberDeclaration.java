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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ledmington.spiq.compiler.SpiqCompiler;

public class TestNumberDeclaration {

    private SpiqCompiler compiler;

    @BeforeEach
    public void setup() {
        compiler = new SpiqCompiler();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a number", "an integer", "a fraction", "a rational", "a real"})
    public void withoutValue(String type) {
        assertEquals(0, compiler.compile("A is " + type + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "12", "0", "+2", "-012", "+036"})
    public void integerDeclaration(String number) {
        assertEquals(0, compiler.compile("A is " + number + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"5/7", "0/3", "2/0", "-1/12", "+13/31", "-06/3", "+07/4", "-5/09", "+6/02"})
    public void fractionDeclaration(String fraction) {
        assertEquals(0, compiler.compile("A is " + fraction + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2", "-3.6", "+6.5", "-03.1", "+06.2", "-9.02", "+7.03"})
    public void realDeclarationNormalForm(String real) {
        assertEquals(0, compiler.compile("A is " + real + "."));
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
    public void realDeclarationExponentialForm(String real) {
        assertEquals(0, compiler.compile("A is " + real + "."));
    }
}
