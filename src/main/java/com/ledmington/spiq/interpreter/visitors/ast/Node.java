/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter.visitors.ast;

import com.ledmington.spiq.interpreter.Visitable;

public abstract class Node implements Visitable {

    private final int line = -1;

    public int getLine() {
        return line;
    }
}
