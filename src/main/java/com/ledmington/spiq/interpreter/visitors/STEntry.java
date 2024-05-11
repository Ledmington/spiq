/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors;

import com.ledmington.spiq.interpreter.Visitable;

public final class STEntry implements Visitable {
    final int nl;
    // final TypeNode type;
    // final int offset;

    public STEntry(int n /*, TypeNode t, int o*/) {
        nl = n;
        // type = t;
        // offset = o;
    }

    // @Override
    // public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
    //     return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    // }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    }
}
