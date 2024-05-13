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
import java.util.ArrayList;
import java.util.List;

public final class SpiqParser {

    private final SpiqToken[] tokens;
    private int i = 0;
    private final List<SpiqNode> nodes;

    public SpiqParser(final String source) {
        this.tokens = new SpiqLexer(source).tokenize().toArray(new SpiqToken[0]);
        this.nodes = new ArrayList<>();
    }

    public SpiqParser(final File file) {
        this.tokens = new SpiqLexer(file).tokenize().toArray(new SpiqToken[0]);
        this.nodes = new ArrayList<>();
    }

    public List<SpiqNode> parse() {
        while (i < tokens.length) {
            nodes.add(parseVariableDeclaration());
        }

        return nodes;
    }

    private void expect(final SpiqToken expected) {
        if (i < tokens.length && !tokens[i].equals(expected)) {
            throw new UnexpectedTokenException(tokens[i], expected);
        }
        i++;
    }

    private VariableDeclarationNode parseVariableDeclaration() {
        if (!(tokens[i] instanceof SpiqID)) {
            throw new UnexpectedTokenException(tokens[i], new SpiqID("<id>"));
        }

        final String id = ((SpiqID) tokens[i]).id();
        i++;

        final SpiqType type;
        NumberLiteral value = null;

        expect(SpiqKeywords.IS);

        if (tokens[i] == SpiqKeywords.A) {
            i++;
            switch (tokens[i]) {
                case SpiqKeywords.NUMBER -> {
                    i++;
                    type = SpiqType.NUMBER;
                }
                case SpiqKeywords.REAL -> {
                    i++;
                    type = SpiqType.REAL;
                }
                case SpiqKeywords.SET -> {
                    i++;
                    type = SpiqType.SET;
                }
                default -> throw new UnexpectedTokenException(tokens[i]);
            }
        } else if (tokens[i] == SpiqKeywords.AN) {
            i++;
            if (tokens[i] == SpiqKeywords.INTEGER) {
                i++;
                type = SpiqType.INTEGER;
            } else {
                throw new UnexpectedTokenException(tokens[i]);
            }
        } else if (tokens[i] instanceof NumberLiteral nl) {
            i++;
            if (nl.isIntegral()) {
                type = SpiqType.INTEGER;
            } else {
                type = SpiqType.REAL;
            }
            value = nl;
        } else {
            throw new UnexpectedTokenException(tokens[i]);
        }

        if (i < tokens.length && tokens[i] != SpiqSymbols.NEWLINE) {
            throw new InvalidDeclaration(id, type, value);
        }

        return new NumberDeclarationNode(id, type, value);
    }
}
