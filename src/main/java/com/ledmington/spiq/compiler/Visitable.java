/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.compiler;

import gen.spiqBaseVisitor;

public interface Visitable {
    <S, E extends Exception> S accept(spiqBaseVisitor<S> visitor) throws E;
}
