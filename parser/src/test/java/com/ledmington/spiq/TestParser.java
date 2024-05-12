/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class TestParser {

    private static Stream<Arguments> validSources() {
        return Stream.of(
                Arguments.of("A is a number.", List.of(new VariableDeclarationNode("A", SpiqType.NUMBER))),
                Arguments.of("A is an integer.", List.of(new VariableDeclarationNode("A", SpiqType.INTEGER))),
                Arguments.of("A is a real.", List.of(new VariableDeclarationNode("A", SpiqType.REAL))),
                Arguments.of("A is a set.", List.of(new VariableDeclarationNode("A", SpiqType.SET))),
                //
                Arguments.of(
                        "A is 5.", List.of(new VariableDeclarationNode("A", SpiqType.INTEGER, new NumberLiteral(5)))),
                Arguments.of(
                        "A is 5.3.", List.of(new VariableDeclarationNode("A", SpiqType.REAL, new NumberLiteral(5.3)))),
                Arguments.of(
                        "A is -1.2e-3.",
                        List.of(new VariableDeclarationNode("A", SpiqType.REAL, new NumberLiteral(-1.2e-3)))));
    }

    @ParameterizedTest
    @MethodSource("validSources")
    public void correct(final String source, final List<SpiqNode> expectedNodes) {
        Path testFile = null;
        try {
            testFile = Files.createTempFile("spiq-", "-test-source");
            Files.writeString(testFile, source, StandardOpenOption.WRITE);
        } catch (final IOException e) {
            fail();
        }
        final SpiqParser parser = new SpiqParser(testFile.toFile());
        assertEquals(expectedNodes, parser.parse());
    }

    private static Stream<Arguments> invalidSources() {
        return Stream.of("A is not a number.", "A is a number").map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("invalidSources")
    public void invalid(final String source) {
        Path testFile = null;
        try {
            testFile = Files.createTempFile("spiq-", "-test-source");
            Files.writeString(testFile, source, StandardOpenOption.WRITE);
        } catch (final IOException e) {
            fail();
        }
        final SpiqParser parser = new SpiqParser(testFile.toFile());
        assertThrows(SpiqParserException.class, parser::parse);
    }
}
