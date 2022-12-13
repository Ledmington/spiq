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
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

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
        System.out.println(file);
        return 0;
    }
}
