/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
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

import com.ledmington.spiq.interpreter.visitors.ASTGenerationSTVisitor;
import com.ledmington.spiq.interpreter.visitors.ExecutorVisitor;
import com.ledmington.spiq.interpreter.visitors.SymbolTableASTVisitor;
import com.ledmington.spiq.interpreter.visitors.ast.Node;

import gen.spiqLexer;
import gen.spiqParser;

public final class SpiqInterperter {

    public SpiqInterperter() {}

    public CompilationResult compile(final CharStream stream) {
        return this.compile(stream.toString());
    }

    /**
     * Executes the given String.
     * @param code
     *      The spiq code to be interpreted.
     * @return
     *      The result of the compilation.
     */
    public CompilationResult compile(final String code) {
        final CharStream chars = CharStreams.fromString(code);
        final spiqLexer lexer = new spiqLexer(chars);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        for (Token token : tokens.getTokens()) {
            System.out.println(token);
        }
        final spiqParser parser = new spiqParser(tokens);

        final ParseTree st = parser.prog();

        System.out.println("Generating AST");
        final ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(true);
        final Node ast = visitor.visit(st);

        System.out.println("Checking symbol table");
        final SymbolTableASTVisitor symTableVisitor = new SymbolTableASTVisitor(true);
        symTableVisitor.visit(ast);

        System.out.println("Executing");
        final ExecutorVisitor executor = new ExecutorVisitor(true);
        executor.visit(ast);

        return new CompilationResult(
                lexer.lexicalErrors,
                parser.getNumberOfSyntaxErrors(),
                symTableVisitor.errors,
                // typeCheckVisitor.errors,
                executor.errors);
    }
}
