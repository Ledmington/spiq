/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class SpiqParser {

    private final SpiqToken[] tokens;
    private int i = 0;
    private final List<SpiqNode> nodes;

    public SpiqParser(final File file) {
        this.tokens = new SpiqLexer(file).tokenize().toArray(new SpiqToken[0]);
        this.nodes = new ArrayList<>();
    }

    public List<SpiqNode> parse() {
        return nodes;
    }
}
