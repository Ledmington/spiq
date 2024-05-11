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
import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;

import com.ledmington.spiq.interpreter.SpiqInterperter;
import com.ledmington.spiq.utils.SpiqUtils;

public final class Spiq {

    public static void main(final String[] args) {
        System.err.println(SpiqUtils.nlJoin(
                "",
                " ________  ________  ___  ________      ",
                "|\\  _____\\|\\   __  \\|\\  \\|\\   __  \\     ",
                "\\ \\  \\____| \\  \\_\\  \\ \\  \\ \\  \\ \\  \\    ",
                " \\ \\_____  \\ \\   ____\\ \\  \\ \\  \\ \\  \\   ",
                "  \\|____|\\  \\ \\  \\___|\\ \\  \\ \\  \\_\\  \\  ",
                "     ___\\_\\  \\ \\__\\    \\ \\__\\ \\_____  \\ ",
                "    |\\________\\|__|     \\|__|\\|___| \\__\\",
                "    \\|_________|                   \\|__|\n"));

        final String filename;
        if (args.length == 0) {
            System.err.println("Expected a filename.");
            System.exit(-1);
        }

        filename = args[0];

        System.out.println("Reading \"" + filename + "\"");

        final SpiqInterperter compiler = new SpiqInterperter();
        try {
            compiler.compile(CharStreams.fromFileName(new File(filename).getAbsolutePath()));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
