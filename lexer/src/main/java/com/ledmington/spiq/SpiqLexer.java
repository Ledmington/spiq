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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SpiqLexer {

    private final char[] v;
    private int i = 0;
    private final List<SpiqToken> tokens;

    public SpiqLexer(final String source) {
        this.v = Objects.requireNonNull(source).toCharArray();
        this.tokens = new ArrayList<>();
    }

    public SpiqLexer(final File file) {
        try {
            this.v = Files.readString(Objects.requireNonNull(file).toPath()).toCharArray();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        this.tokens = new ArrayList<>();
    }

    public List<SpiqToken> tokenize() {
        while (i < v.length) {
            skipBlanks();

            if (i >= v.length) {
                break;
            }

            if (v[i] == '.') {
                tokens.add(SpiqSymbols.DOT);
                i++;
            } else if (v[i] == '\n') {
                tokens.add(SpiqSymbols.NEWLINE);
                i++;
            } else if (isDigit(v[i]) || v[i] == '-' || v[i] == '+') {
                tokens.add(parseNumberLiteral());
            } else if (isAlphabetic(v[i])) {
                final StringBuilder sb = new StringBuilder();
                while (i < v.length && isAlphabetic(v[i])) {
                    sb.append(v[i]);
                    i++;
                }
                final String token = sb.toString();

                tokens.add(
                        switch (token) {
                            case "is" -> SpiqKeywords.IS;
                            case "a" -> SpiqKeywords.A;
                            case "an" -> SpiqKeywords.AN;
                            case "number" -> SpiqKeywords.NUMBER;
                            case "integer" -> SpiqKeywords.INTEGER;
                            case "real" -> SpiqKeywords.REAL;
                            case "set" -> SpiqKeywords.SET;
                            default -> new SpiqID(token);
                        });
            } else {
                throw new SpiqLexerException(String.format("Invalid character '%c'.", v[i]));
            }
        }

        return tokens;
    }

    private SpiqToken parseNumberLiteral() {
        final StringBuilder sb = new StringBuilder();
        if (i < v.length && (v[i] == '-' || v[i] == '+')) {
            sb.append(v[i]);
            i++;
        }

        while (i < v.length && isDigit(v[i])) {
            sb.append(v[i]);
            i++;
        }

        if (i < v.length && v[i] == '.') {
            sb.append(v[i]);
            i++;

            while (i < v.length && isDigit(v[i])) {
                sb.append(v[i]);
                i++;
            }
        }

        if (i < v.length && v[i] == 'e') {
            sb.append(v[i]);
            i++;
            if (i < v.length && (v[i] == '-' || v[i] == '+')) {
                sb.append(v[i]);
                i++;
            }
            readDigits(sb);
        }

        try {
            return new NumberLiteral(sb.toString());
        } catch (final NumberFormatException e) {
            throw new SpiqInvalidLiteralException(sb.toString());
        }
    }

    private void readDigits(final StringBuilder sb) {
        while (i < v.length) {
            if (!isDigit(v[i])) {
                throw new SpiqLexerException(String.format("Lexical error: expected a digit but was %c", v[i]));
            }
            sb.append(v[i]);
            i++;
        }
    }

    private void skipBlanks() {
        while (i < v.length && isWhitespace(v[i])) {
            i++;
        }
    }

    private boolean isAlphabetic(final char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isDigit(final char ch) {
        return switch (ch) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }

    private boolean isWhitespace(final char ch) {
        return switch (ch) {
            case ' ', '\t', '\r' -> true;
            default -> false;
        };
    }
}
