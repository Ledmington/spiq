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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class TestLexer {

    private static Stream<Arguments> validSources() {
        final List<Arguments> keywords = Arrays.stream(SpiqKeywords.values())
                .map(kw -> Arguments.of(kw.name().toLowerCase(Locale.US), List.of(kw)))
                .toList();
        return Stream.concat(
                keywords.stream(),
                Stream.of(Arguments.of(
                        "A is a number",
                        List.of(new SpiqID("A"), SpiqKeywords.IS, SpiqKeywords.A, SpiqKeywords.NUMBER))));
    }

    @ParameterizedTest
    @MethodSource("validSources")
    public void correct(final String source, final List<SpiqToken> expectedTokens) {
        Path testFile = null;
        try {
            testFile = Files.createTempFile("spiq-", "-test-source");
            Files.writeString(testFile, source, StandardOpenOption.WRITE);
        } catch (final IOException e) {
            fail();
        }
        final SpiqLexer lexer = new SpiqLexer(testFile.toFile());
        assertEquals(expectedTokens, lexer.tokenize());
    }

    private static Stream<Arguments> invalidSources() {
        return Stream.of("@").map(Arguments::of);
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
        final SpiqLexer lexer = new SpiqLexer(testFile.toFile());
        assertThrows(SpiqLexerException.class, lexer::tokenize);
    }
}
