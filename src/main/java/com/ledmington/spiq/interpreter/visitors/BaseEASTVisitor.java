/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors;

import com.ledmington.spiq.interpreter.exc.UnimplementedException;

public class BaseEASTVisitor<S, E extends Exception> extends BaseASTVisitor<S, E> {

    protected BaseEASTVisitor() {
        super();
    }

    protected BaseEASTVisitor(final boolean debug) {
        super(debug);
    }

    protected void printSTentry(final String s) {
        System.out.println(indent + "STentry: " + s);
    }

    public S visitSTentry(final STEntry s) throws E {
        throw new UnimplementedException();
    }
}
