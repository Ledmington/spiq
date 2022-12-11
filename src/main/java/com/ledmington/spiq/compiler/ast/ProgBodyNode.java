/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.compiler.ast;

import java.util.List;

import gen.spiqBaseVisitor;

public class ProgBodyNode extends Node {

    private final List<DeclNode> declarations;

    public ProgBodyNode(final List<DeclNode> nodes) {
        super();
        declarations = nodes;
    }

    public List<DeclNode> getDeclarations() {
        return declarations;
    }

    @Override
    public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
        return null;
    }
}
