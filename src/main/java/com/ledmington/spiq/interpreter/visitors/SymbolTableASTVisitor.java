/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors;

import com.ledmington.spiq.interpreter.exc.VoidException;
import com.ledmington.spiq.interpreter.visitors.ast.DeclNode;
import com.ledmington.spiq.interpreter.visitors.ast.IdNode;
import com.ledmington.spiq.interpreter.visitors.ast.ProgBodyNode;
import com.ledmington.spiq.interpreter.visitors.ast.numbers.NumberNode;

public final class SymbolTableASTVisitor extends BaseASTVisitor<Void, VoidException> {

    public int errors = 0;

    public SymbolTableASTVisitor(final boolean debug) {
        super(debug);
    }

    public SymbolTableASTVisitor() {
        super();
    }

    @Override
    public Void visitNode(final ProgBodyNode node) {
        if (debug) {
            printNode(node);
        }

        for (DeclNode decl : node.getDeclarations()) {
            visit(decl);
        }

        return null;
    }

    @Override
    public Void visitNode(final DeclNode node) {
        if (debug) {
            printNode(node);
        }

        visit(node.id());
        visit(node.number());

        return null;
    }

    @Override
    public Void visitNode(final IdNode node) {
        if (debug) {
            printNode(node);
        }

        return null;
    }

    @Override
    public Void visitNode(final NumberNode node) {
        if (debug) {
            printNode(node);
        }

        return null;
    }
}
