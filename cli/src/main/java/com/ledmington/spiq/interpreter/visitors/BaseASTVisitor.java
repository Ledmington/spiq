/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors;

import com.ledmington.spiq.interpreter.CompilerUtils;
import com.ledmington.spiq.interpreter.Visitable;
import com.ledmington.spiq.interpreter.exc.UnimplementedException;
import com.ledmington.spiq.interpreter.visitors.ast.DeclNode;
import com.ledmington.spiq.interpreter.visitors.ast.IdNode;
import com.ledmington.spiq.interpreter.visitors.ast.Node;
import com.ledmington.spiq.interpreter.visitors.ast.ProgBodyNode;
import com.ledmington.spiq.interpreter.visitors.ast.numbers.NumberNode;

public class BaseASTVisitor<S, E extends Exception> {

    protected final boolean debug;
    protected String indent;

    protected BaseASTVisitor(final boolean debug) {
        this.debug = debug;
    }

    protected BaseASTVisitor() {
        this(false);
    }

    protected void printNode(final Node n) {
        System.out.println(indent + CompilerUtils.extractNodeName(n.getClass().getName()));
    }

    protected void printNode(final Node n, String s) {
        System.out.println(indent + CompilerUtils.extractNodeName(n.getClass().getName()) + ": " + s);
    }

    public S visit(Visitable v) throws E {
        return visit(v, ""); // performs unmarked visit
    }

    public S visit(Visitable v, String mark) throws E { // when printing marks this visit with string mark
        if (v == null) {
            return null;
        }
        if (debug) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            indent += mark; // inserts mark
            try {
                return visitByAcc(v);
            } finally {
                indent = temp;
            }
        } else return visitByAcc(v);
    }

    S visitByAcc(Visitable v) throws E {
        return v.accept(this);
    }

    public S visitNode(ProgBodyNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(DeclNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(IdNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(NumberNode n) throws E {
        throw new UnimplementedException();
    }
}
