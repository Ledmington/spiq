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

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class TestLexer {

    private static Stream<Arguments> validSources() {
        final Stream<Arguments> keywords = Arrays.stream(SpiqKeywords.values())
                .map(kw -> Arguments.of(kw.name().toLowerCase(Locale.US), List.of(kw)));
        final Stream<Arguments> numberLiterals = Stream.of(
                Arguments.of("0", List.of(new NumberLiteral(0))),
                Arguments.of("1", List.of(new NumberLiteral(1))),
                Arguments.of("-1", List.of(new NumberLiteral(-1))),
                Arguments.of(
                        "123456789012345678901234567890", List.of(new NumberLiteral("123456789012345678901234567890"))),
                Arguments.of(
                        "-123456789012345678901234567890",
                        List.of(new NumberLiteral("-123456789012345678901234567890"))),
                Arguments.of("1.2340", List.of(new NumberLiteral(1.234))),
                Arguments.of("-1.2340", List.of(new NumberLiteral(-1.234))),
                Arguments.of("0.000000000000001", List.of(new NumberLiteral(0.000000000000001))),
                Arguments.of("-0.000000000000001", List.of(new NumberLiteral(-0.000000000000001))),
                Arguments.of("1e5", List.of(new NumberLiteral(100000))),
                Arguments.of("-1e5", List.of(new NumberLiteral(-100000))),
                Arguments.of("1e-5", List.of(new NumberLiteral(0.00001))),
                Arguments.of("-1e-5", List.of(new NumberLiteral(-0.00001))));
        return Stream.concat(
                Stream.concat(keywords, numberLiterals),
                Stream.of(Arguments.of(
                        "A is a number",
                        List.of(new SpiqID("A"), SpiqKeywords.IS, SpiqKeywords.A, SpiqKeywords.NUMBER))));
    }

    @ParameterizedTest
    @MethodSource("validSources")
    public void correct(final String source, final List<SpiqToken> expectedTokens) {
        final SpiqLexer lexer = new SpiqLexer(source);
        assertEquals(expectedTokens, lexer.tokenize());
    }

    private static Stream<Arguments> invalidSources() {
        return Stream.of("@").map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("invalidSources")
    public void invalid(final String source) {
        final SpiqLexer lexer = new SpiqLexer(source);
        assertThrows(SpiqLexerException.class, lexer::tokenize);
    }

    private static Stream<Arguments> invalidLiterals() {
        return Stream.of("1-", "1.a", "").map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("invalidLiterals")
    public void wrongLiterals(final String source) {
        final SpiqLexer lexer = new SpiqLexer(source);
        assertThrows(SpiqInvalidLiteralException.class, lexer::tokenize);
    }
}
