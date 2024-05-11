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
import java.util.ArrayList;
import java.util.List;

public final class SpiqParser {

    private final SpiqToken[] tokens;
    private int i = 0;
    private final List<SpiqNode> nodes;

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
        if (i < tokens.length && tokens[i] != expected) {
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

        expect(SpiqKeywords.IS);
        expect(SpiqKeywords.A);
        expect(SpiqKeywords.NUMBER);
        expect(SpiqSymbols.DOT);

        return new VariableDeclarationNode(id, SpiqType.NUMBER);
    }
}
