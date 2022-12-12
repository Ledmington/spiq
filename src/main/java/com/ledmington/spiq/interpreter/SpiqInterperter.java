/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import com.ledmington.spiq.interpreter.ast.Node;
import com.ledmington.spiq.interpreter.vm.SVM;
import com.ledmington.spiq.interpreter.vm.SpiqVM;

import gen.spiqLexer;
import gen.spiqParser;

public final class SpiqInterperter {

    private final SpiqVM vm = new SVM();

    public SpiqInterperter() {}

    public int compile(final CharStream stream) {
        return this.compile(stream.toString());
    }

    /**
     * Compiles the given String.
     * @param code
     *      The spiq code to be compiled.
     * @return
     *      The number of errors.
     */
    public int compile(final String code) {
        final CharStream chars = CharStreams.fromString(code);
        final spiqLexer lexer = new spiqLexer(chars);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        for (Token token : tokens.getTokens()) {
            System.out.println(token);
        }
        final spiqParser parser = new spiqParser(tokens);

        final ParseTree st = parser.prog();

        final ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(true); // use true to visualize the ST
        final Node ast = visitor.visit(st); // TODO fix unused "ast"

        return lexer.lexicalErrors;
    }
}
