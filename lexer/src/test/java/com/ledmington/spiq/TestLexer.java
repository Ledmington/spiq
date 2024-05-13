/*
* spiq - Human readable programming language
* Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
        final Stream<Arguments> symbols =
                Arrays.stream(SpiqSymbols.values()).map(s -> Arguments.of(s.repr(), List.of(s)));
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
                Stream.concat(
                        symbols,
                        Stream.of(Arguments.of(
                                "A is a number",
                                List.of(new SpiqID("A"), SpiqKeywords.IS, SpiqKeywords.A, SpiqKeywords.NUMBER)))));
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
        return Stream.of("1-", "1.a").map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("invalidLiterals")
    public void wrongLiterals(final String source) {
        final SpiqLexer lexer = new SpiqLexer(source);
        assertThrows(SpiqInvalidLiteralException.class, lexer::tokenize);
    }
}
