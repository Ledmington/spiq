/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.antlr.v4.runtime.CharStreams;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.ledmington.spiq.interpreter.SpiqInterperter;
import com.ledmington.spiq.utils.SpiqUtils;

@Command(
        name = "spiq",
        mixinStandardHelpOptions = true,
        version = "spiq 0.1.0",
        description = "Spiq programming language interpreter.")
public final class SpiqCli implements Callable<Integer> {

    @Parameters(index = "0", description = "Input file.")
    private File file;

    // @Option(
    //         names = {"-i", "--interactive"},
    //         description = "MD5, SHA-1, SHA-256, ...")
    // private String algorithm = "SHA-256";

    @Override
    public Integer call() throws Exception {
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

        // if (args.length < 2) {
        //     // System.err.println("\nError: No input files specified.\n");
        //     // System.err.flush();
        //     // System.exit(-1);
        //     filename = "prova.spiq";
        // } else {
        //     filename = args[1];
        // }

        System.out.println("Reading \"" + file + "\"");

        try {
            final SpiqInterperter compiler = new SpiqInterperter();
            compiler.compile(CharStreams.fromFileName(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
