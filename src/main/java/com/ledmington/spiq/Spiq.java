/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq;

import picocli.CommandLine;

public final class Spiq {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new SpiqCli()).execute(args);
        System.exit(exitCode);
    }
}
