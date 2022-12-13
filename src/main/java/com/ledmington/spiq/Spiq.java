/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;

import picocli.CommandLine;

import com.ledmington.spiq.interpreter.SpiqInterperter;
import com.ledmington.spiq.utils.SpiqUtils;

public final class Spiq {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new SpiqCli()).execute(args);
        System.exit(exitCode);

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

        final String filename = "prova.spiq";

        // if (args.length < 2) {
        //     // System.err.println("\nError: No input files specified.\n");
        //     // System.err.flush();
        //     // System.exit(-1);
        //     filename = "prova.spiq";
        // } else {
        //     filename = args[1];
        // }

        System.out.println("Reading \"" + filename + "\"");

        try {
            final SpiqInterperter compiler = new SpiqInterperter();
            compiler.compile(CharStreams.fromFileName(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
