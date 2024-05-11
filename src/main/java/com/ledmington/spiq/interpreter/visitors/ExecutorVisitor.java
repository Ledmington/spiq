/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors;

public final class ExecutorVisitor extends BaseEASTVisitor<Void, RuntimeException> {

    public int errors = 0;

    public ExecutorVisitor(final boolean debug) {
        super(debug);
    }

    public ExecutorVisitor() {
        super();
    }
}
