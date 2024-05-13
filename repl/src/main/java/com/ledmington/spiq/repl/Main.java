/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.repl;

import java.io.Console;

import com.ledmington.spiq.SpiqParser;

public final class Main {

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

        final Console console = System.console();

        while (true) {
            System.out.print(" \033[36m>>>\033[0m ");
            final String line = console.readLine();
            if (line.isBlank() || line.isEmpty()) {
                continue;
            }

            final SpiqParser parser = new SpiqParser(line);
            System.out.println(parser.parse());
        }
    }
}
