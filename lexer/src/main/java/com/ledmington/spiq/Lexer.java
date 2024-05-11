/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Lexer {

    private final char[] v;
    private int i = 0;
    private final List<SpiqToken> tokens;

    public Lexer(final File file) {
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

            final StringBuilder sb = new StringBuilder();
            while (i < v.length && !Character.isWhitespace(v[i])) {
                sb.append(v[i]);
                i++;
            }
            final String token = sb.toString();
            tokens.add(
                    switch (token) {
                        case "is" -> SpiqKeywords.IS;
                        case "a" -> SpiqKeywords.A;
                        case "number" -> SpiqKeywords.NUMBER;
                        default -> new SpiqID(token);
                    });
        }

        return tokens;
    }

    private void skipBlanks() {
        while (i < v.length && Character.isWhitespace(v[i])) {
            i++;
        }
    }
}
