/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast;

import java.util.Collections;
import java.util.List;

import com.ledmington.spiq.interpreter.visitors.BaseASTVisitor;

public class ProgBodyNode extends Node {

    private final List<DeclNode> declarations;

    public ProgBodyNode(final List<DeclNode> nodes) {
        super();
        declarations = Collections.unmodifiableList(nodes);
    }

    public List<DeclNode> getDeclarations() {
        return declarations;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
