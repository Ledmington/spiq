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
import java.nio.file.Files;

public final class Spiq {

    public static void main(final String[] args) {
        System.err.println(String.join(
                "\n",
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

        try {
            System.out.println(Files.readString(new File(filename).toPath()));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
